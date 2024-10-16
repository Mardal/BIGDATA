from pyspark.sql import SparkSession

# Add here your team number teamx
team = 37

# location of your Hive database in HDFS
warehouse = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName("{} - spark ML".format(team))\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", warehouse)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .enableHiveSupport()\
        .getOrCreate()

spark.sql("SHOW DATABASES").show()
spark.sql("USE team37_projectdb").show()
spark.sql("SHOW TABLES").show()
spark.sql("SELECT * FROM team37_projectdb.flight_data_bucketed LIMIT 10").show()