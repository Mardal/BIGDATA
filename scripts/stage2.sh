hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc

password=$(head -n 1 secrets/hive.pass)
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/db.hql > output/hive_results.txt
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/partbuck.hql > output/part_results.txt

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/q1.hql
echo "ID,flights_count,ORIGIN,DEST" > output/q1.csv
hdfs dfs -cat project/output/q1/* >> output/q1.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/q2.hql
echo "Route_id,Total_Cancellations,A_Count,B_Count,C_Count,D_Count" > output/q2.csv
hdfs dfs -cat project/output/q2/* >> output/q2.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/q3.hql
echo "ID,avg_delay,median_delay,flights_count" > output/q3.csv
hdfs dfs -cat project/output/q3/* >> output/q3.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/q4.hql
echo "Year_Month,avg_delay,median_delay,flights_amount" > output/q4.csv
hdfs dfs -cat project/output/q4/* >> output/q4.csv

beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team37 -p $password -f sql/q5.hql
echo "Year,Month,Total_Cancellations,A_Count,B_Count,C_Count,D_Count" > output/q5.csv
hdfs dfs -cat project/output/q5/* >> output/q5.csv