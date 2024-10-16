from pyspark.sql import SparkSession
import math
from pyspark.sql import functions as F
from pyspark.ml import Transformer, Pipeline
from pyspark.ml.param.shared import HasInputCol, HasOutputCols
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql.types import DoubleType
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler,StandardScaler, Word2Vec, Tokenizer, RegexTokenizer
from pyspark.sql.functions import col
from pyspark.ml.evaluation import RegressionEvaluator
from pyspark.ml.tuning import CrossValidator, ParamGridBuilder
from pyspark.ml.regression import LinearRegression, GBTRegressor
import os

team = 37

warehouse = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName("{} - spark ML".format(team))\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()
spark.sql("USE team37_projectdb")
flights = spark.read.format("avro").table('team37_projectdb.flight_data_bucketed')
routes = spark.read.format("avro").table('team37_projectdb.route_data_partitioned')
airports = spark.read.format("avro").table('team37_projectdb.airports_data_load').withColumnRenamed("latitude", "origin_latitude").withColumnRenamed("longitude", "origin_longitude")
airports1 = spark.read.format("avro").table('team37_projectdb.airports_data_load').withColumnRenamed("latitude", "dest_latitude").withColumnRenamed("longitude", "dest_longitude").withColumnRenamed("airport_name", "dest_airport_name")
df = flights.join(routes, on='route_id', how='inner')
df = df.join(airports1, df.dest == airports1.dest_airport_name, how='inner')
df = df.join(airports, df.origin == airports.airport_name, how='inner')
class Encoder(Transformer, HasInputCol, HasOutputCols,
              DefaultParamsReadable, DefaultParamsWritable):
    def __init__(self, inputCol, outputCols, n):
        super(Encoder, self).__init__()
        self._set(inputCol=inputCol, outputCols=outputCols)
        self.n = n

    def _transform(self, dataset):
        input_col = self.getInputCol()
        output_cols = self.getOutputCols()
        dataset = dataset.withColumn(output_cols[0],
                                     F.sin(2 * math.pi*F.col(input_col) / self.n))
        return dataset


df = df.withColumn("year", F.year("fl_date"))
df = df.withColumn("month", F.month("fl_date"))
df = df.withColumn("day", F.dayofmonth("fl_date"))
df = Encoder("month", ["month"], 12).transform(df)
df = Encoder("day", ["day"], 31).transform(df)
from pyspark.sql.functions import col, floor, abs
def split_time(column_name):
    hours = floor(col(column_name) / 100).alias(f"{column_name}_hours")
    minutes = floor(col(column_name) % 100).alias(f"{column_name}_minutes")
    return hours, minutes
time_columns = ["crs_dep_time","crs_arr_time", "arr_time"]
for col_name in time_columns:
    hours, minutes = split_time(col_name)
    df = df.withColumn(f"{col_name}_hours", hours)
    df = df.withColumn(f"{col_name}_minutes", minutes)
df = df.withColumn("delta_minutes", (col("crs_arr_time_hours") * 60 + col("crs_arr_time_minutes") - col("crs_dep_time_hours") * 60 - col("crs_dep_time_minutes")))
df = Encoder("crs_dep_time_hours", ["crs_dep_time_hours"], 24).transform(df)
df = Encoder("crs_arr_time_hours", ["crs_arr_time_hours"], 24).transform(df)
df = Encoder("arr_time_hours", ["arr_time_hours"], 24).transform(df)
features = ['arr_delay', 'crs_elapsed_time', 'year', 'month', 'day', 'airport_name', 'dest_latitude', 'dest_longitude', 'origin_latitude', 'origin_longitude', 'crs_dep_time_hours', 'crs_arr_time_hours', 'delta_minutes']
df_filtered = df.select(*features)
df_filtered = df_filtered.withColumnRenamed("arr_delay","label")
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, OneHotEncoder, VectorAssembler,StandardScaler, Word2Vec, Tokenizer, RegexTokenizer
from pyspark.sql.functions import col
categoricalCols = ['airport_name']
others = ['crs_elapsed_time', 'year', 'month', 'day', 'dest_latitude', 'dest_longitude', 'origin_latitude', 'origin_longitude', 'crs_dep_time_hours', 'crs_arr_time_hours', 'delta_minutes']

indexers = [ StringIndexer(inputCol=c, outputCol="{0}_indexed".format(c)).setHandleInvalid("skip") for c in categoricalCols ]

encoders = [ OneHotEncoder(inputCol=indexer.getOutputCol(), outputCol="{0}_encoded".format(indexer.getOutputCol())) for indexer in indexers ]

assembler = VectorAssembler(inputCols=[encoder.getOutputCol() for encoder in encoders] + others, outputCol="features")

scaler = StandardScaler(inputCol="features", outputCol="scaledFeatures", withStd=True, withMean=True)

pipeline = Pipeline(stages=indexers + encoders + [assembler, scaler])

model = pipeline.fit(df_filtered)

data = model.transform(df_filtered)
(train_data, test_data) = data.randomSplit([0.7, 0.3], seed = 10)



def run(command):
    return os.popen(command).read()

train_data.select("scaledFeatures", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("scaledFeatures", "label")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")

lr = LinearRegression(featuresCol="scaledFeatures", labelCol="label")

# Create a ParamGridBuilder and add the parameters to search over
paramGrid = ParamGridBuilder() \
    .addGrid(lr.regParam, [0.1, 0.01]) \
    .addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0]) \
    .build()

# Create a CrossValidator instance
crossval = CrossValidator(estimator=lr,
                          estimatorParamMaps=paramGrid,
                          evaluator=RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse"),
                          numFolds=5)
cvModel = crossval.fit(train_data)

model1 = cvModel.bestModel
model1.write().overwrite().save("project/models/model1")
run("hdfs dfs -get project/models/model1 models/model1")

predictions = cvModel.transform(test_data)
# Evaluate the performance of the model
evaluator = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
rmse1 = evaluator.evaluate(predictions)
evaluator_r2 = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")
r21 = evaluator_r2.evaluate(predictions)
predictions = predictions.withColumn("difference", abs(predictions["prediction"] - predictions["label"]))

filtered_predictions = predictions.filter(predictions["difference"] > 15)
count_filtered = filtered_predictions.count()
total_count = predictions.count()
m15_1 = 100 - (count_filtered / total_count) * 100

predictions = predictions.withColumn("difference", abs(predictions["prediction"] - predictions["label"]))

filtered_predictions = predictions.filter(predictions["difference"] > 30)

count_filtered = filtered_predictions.count()

total_count = predictions.count()
m30_1 = 100 - (count_filtered / total_count) * 100

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model1_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model1_predictions.csv/*.csv > output/model1_predictions.csv")

# Calculate the absolute error
predictions = predictions.withColumn("error", F.abs(predictions["label"] - predictions["prediction"]))

# Calculate the median error
median_error = predictions.approxQuantile("error", [0.5], 0.01)[0]
print("Median Error on test data = %g" % median_error)

gbt = GBTRegressor(featuresCol="scaledFeatures", labelCol="label")

parameters = {
    'maxDepth': [5, 10],
    'maxIter': [5, 10]
}

paramGrid = (ParamGridBuilder()
             .addGrid(gbt.maxDepth, parameters['maxDepth'])
             .addGrid(gbt.maxIter, parameters['maxIter'])
             .build())

crossval = CrossValidator(estimator=gbt,
                          estimatorParamMaps=paramGrid,
                          evaluator=RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse"),
                          numFolds=3)

cvModel = crossval.fit(train_data)
model2 = cvModel.bestModel

model2.write().overwrite().save("project/models/model2")

run("hdfs dfs -get project/models/model2 models/model2")


predictions = cvModel.transform(test_data)

predictions.select("label", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/model2_predictions.csv")

run("hdfs dfs -cat project/output/model2_predictions.csv/*.csv > output/model2_predictions.csv")

evaluator = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="rmse")
rmse2 = evaluator.evaluate(predictions)

evaluator = RegressionEvaluator(labelCol="label", predictionCol="prediction", metricName="r2")
r22 = evaluator.evaluate(predictions)

predictions = predictions.withColumn("difference", abs(predictions["prediction"] - predictions["label"]))

filtered_predictions = predictions.filter(predictions["difference"] > 15)
count_filtered = filtered_predictions.count()
total_count = predictions.count()
m15_2 = 100 - (count_filtered / total_count) * 100

predictions = predictions.withColumn("difference", abs(predictions["prediction"] - predictions["label"]))

filtered_predictions = predictions.filter(predictions["difference"] > 30)

count_filtered = filtered_predictions.count()

total_count = predictions.count()
m30_2 = 100 - (count_filtered / total_count) * 100


models = [[str(model1),rmse1, r21, m15_1, m30_1], [str(model2),rmse2, r22, m15_2, m30_2]]

df = spark.createDataFrame(models, ["model", "RMSE", "R2", "m_check15", "m_check30"])
df.show(truncate=False)


df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .option("sep", ",")\
    .option("header","true")\
    .save("project/output/evaluation.csv")

run("hdfs dfs -cat project/output/evaluation.csv/*.csv > output/evaluation.csv")