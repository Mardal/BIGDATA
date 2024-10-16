USE team37_projectdb;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results (
    Route_ID INT,
    Total_Cancellations INT,
    A_Count INT,
    B_Count INT,
    C_Count INT,
    D_Count INT
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q2';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT OVERWRITE TABLE q2_results
SELECT 
    f.ROUTE_ID AS Route_ID,
    COUNT(*) AS Total_Cancellations,
    SUM(CASE WHEN f.cancellation_code = 'A' THEN 1 ELSE 0 END) AS A_Count,
    SUM(CASE WHEN f.cancellation_code = 'B' THEN 1 ELSE 0 END) AS B_Count,
    SUM(CASE WHEN f.cancellation_code = 'C' THEN 1 ELSE 0 END) AS C_Count,
    SUM(CASE WHEN f.cancellation_code = 'D' THEN 1 ELSE 0 END) AS D_Count
FROM 
    flight_data_bucketed AS f
WHERE 
    f.cancellation_code IN ('A', 'B', 'C', 'D')
GROUP BY 
    f.ROUTE_ID;

INSERT OVERWRITE DIRECTORY 'project/output/q2' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q2_results;