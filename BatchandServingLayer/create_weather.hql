
create external table weather_nian(
  datetime string,
  Temperature float,
  Humidity float,
  Rain float
  )
  row format serde 'org.apache.hadoop.hive.serde2.OpenCSVSerde'

WITH SERDEPROPERTIES (
   "separatorChar" = "\,"
)
STORED AS TEXTFILE
  location '/tmp/nian/weather_nian';
