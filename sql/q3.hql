USE team37_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results (
    ID INT,
    avg_delay FLOAT,
    median_delay FLOAT,
    flights_amount INT
    )
location 'project/hive/warehouse/q2'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT OVERWRITE TABLE q3_results
SELECT 
    f.ROUTE_ID AS Route_ID,
    AVG(f.dep_delay) AS avg_delay,
    percentile_approx(f.dep_delay, 0.5) AS median_delay,
    COUNT(*) as flights_amount
FROM 
    flight_data_bucketed AS f
GROUP BY 
    f.ROUTE_ID
ORDER BY 
    median_delay DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q3' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q3_results;