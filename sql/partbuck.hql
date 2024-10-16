USE team37_projectdb;
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict
SET hive.exec.max.dynamic.partitions=1000;
SET hive.exec.max.dynamic.partitions.pernode=1000;

SELECT * FROM route_data LIMIT 10;

CREATE EXTERNAL TABLE IF NOT EXISTS route_data_partitioned (
    DEST STRING,
    ORIGIN_CITY STRING,
    DEST_CITY STRING,
    ROUTE_ID INT,
    MOST_COMMON_DISTANCE FLOAT
)
PARTITIONED BY (ORIGIN STRING)
STORED AS AVRO LOCATION 'project/hive/warehouse/route_data_partitioned' 
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT OVERWRITE TABLE route_data_partitioned PARTITION (ORIGIN)
SELECT 
    DEST,
    ORIGIN_CITY,
    DEST_CITY,
    ROUTE_ID,
    MOST_COMMON_DISTANCE,
    ORIGIN
FROM route_data;

SELECT * FROM route_data_partitioned WHERE ORIGIN='ATL' LIMIT 10;

CREATE EXTERNAL TABLE IF NOT EXISTS flight_data_bucketed (
    FL_DATE STRING,
    DOT_CODE INT,
    FL_NUMBER INT,
    CRS_DEP_TIME INT,
    DEP_TIME FLOAT,
    DEP_DELAY FLOAT,
    TAXI_OUT FLOAT,
    WHEELS_OFF FLOAT,
    WHEELS_ON FLOAT,
    TAXI_IN FLOAT,
    CRS_ARR_TIME INT,
    ARR_TIME FLOAT,
    ARR_DELAY FLOAT,
    CANCELLED FLOAT,
    CANCELLATION_CODE STRING,
    DIVERTED FLOAT,
    CRS_ELAPSED_TIME FLOAT,
    ELAPSED_TIME FLOAT,
    AIR_TIME FLOAT,
    ID INT,
    ROUTE_ID INT
)
CLUSTERED BY (ROUTE_ID) INTO 20 BUCKETS
STORED AS AVRO LOCATION 'project/hive/warehouse/route_data_bucketed' 
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT OVERWRITE TABLE flight_data_bucketed
SELECT 
    from_unixtime(FLOOR(CAST(FL_DATE AS BIGINT)/1000), 'yyyy-MM-dd') as FL_DATE,
    DOT_CODE,
    FL_NUMBER,
    CRS_DEP_TIME,
    DEP_TIME,
    DEP_DELAY,
    TAXI_OUT,
    WHEELS_OFF,
    WHEELS_ON,
    TAXI_IN,
    CRS_ARR_TIME,
    ARR_TIME,
    ARR_DELAY,
    CANCELLED,
    CANCELLATION_CODE,
    DIVERTED,
    CRS_ELAPSED_TIME,
    ELAPSED_TIME,
    AIR_TIME,
    ID,
    ROUTE_ID
FROM flight_data;

SELECT * FROM flight_data_bucketed LIMIT 10;

CREATE EXTERNAL TABLE IF NOT EXISTS airports_data_load (
    AIRPORT_NAME STRING,
    LATITUDE FLOAT,
    LONGITUDE FLOAT
)
STORED AS AVRO LOCATION 'project/hive/warehouse/airports_data_load' 
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

INSERT OVERWRITE TABLE airports_data_load
SELECT 
    AIRPORT_NAME,
    LATITUDE,
    LONGITUDE
FROM airports_data;

SELECT * FROM airports_data_load LIMIT 10;

CREATE EXTERNAL TABLE IF NOT EXISTS evaluation (
    model STRING,
    RMSE FLOAT,
    R2 FLOAT,
    m_check15 FLOAT,
    m_check30 FLOAT
)
STORED AS AVRO LOCATION 'project/hive/warehouse/evaluation' 
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');
