USE team37_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results (
    ID INT,
    flights_count INT,
    ORIGIN STRING,
    DEST STRING
    )
location 'project/hive/warehouse/q1'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT OVERWRITE TABLE q1_results
SELECT 
    f.ROUTE_ID AS Route_ID,
    COUNT(*) AS Flights_count,
    r.ORIGIN, 
    r.DEST 
FROM 
    flight_data_bucketed AS f
JOIN 
    route_data_partitioned AS r 
ON 
    f.ROUTE_ID = r.ROUTE_ID
GROUP BY 
    f.ROUTE_ID,
    r.ORIGIN, 
    r.DEST
ORDER BY 
    Flights_count DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;