
create external table COVID_nian(
  datetime STRING,
  weekday STRING,
  tested INT,
  positive INT,
  Month INT,
  Day INT
  )
  row format serde 'org.apache.hadoop.hive.serde2.OpenCSVSerde'

WITH SERDEPROPERTIES (
   "separatorChar" = "\,"
)
STORED AS TEXTFILE
  location '/tmp/nian/covid_nian';
