USE team37_projectdb;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results (
    Year INT,
    Month INT,
    avg_delay FLOAT,
    median_delay FLOAT,
    flights_amount INT
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION 'project/hive/warehouse/q4';

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT OVERWRITE TABLE q4_results
SELECT 
    year(f.fl_date) AS Year,
    month(f.fl_date) AS Month,
    AVG(f.dep_delay) AS avg_delay,
    percentile_approx(f.dep_delay, 0.5) AS median_delay,
    COUNT(*) AS flights_amount
FROM 
    flight_data_bucketed AS f
GROUP BY 
    year(f.fl_date),
    month(f.fl_date)
ORDER BY 
    year, month, median_delay DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q4' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q4_results;