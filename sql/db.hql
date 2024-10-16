DROP DATABASE IF EXISTS team37_projectdb CASCADE;;
CREATE DATABASE team37_projectdb LOCATION "project/hive/warehouse";
USE team37_projectdb;
CREATE EXTERNAL TABLE route_data STORED AS AVRO LOCATION 'project/warehouse/route_data' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/route_data.avsc');
CREATE EXTERNAL TABLE flight_data STORED AS AVRO LOCATION 'project/warehouse/flight_data' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/flight_data.avsc');
CREATE EXTERNAL TABLE airports_data STORED AS AVRO LOCATION 'project/warehouse/airports_data' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/airports_data.avsc');
CREATE EXTERNAL TABLE evaluation STORED AS AVRO LOCATION 'project/warehouse/evaluation' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/evaluation.avsc');

SELECT * FROM route_data LIMIT 10;
SELECT * FROM airports_data LIMIT 10
SELECT * FROM evaluation LIMIT 10