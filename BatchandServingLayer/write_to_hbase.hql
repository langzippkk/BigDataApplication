create external table processed_weather_covid_nian (
      datetime string,
      Temperature INT,
      Humidity INT,
      Rain INT,
      weekday STRING,
      tested INT,
      positive INT)
STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler'
WITH SERDEPROPERTIES ('hbase.columns.mapping' = ':key,weather:Temperature#b,
  weather:Humidity#b,weather:Rain#b,weather:weekday#b,weather:tested#b,
  weather:positive#b')
TBLPROPERTIES ('hbase.table.name' = 'processed_weather_covid_nian');


insert overwrite table processed_weather_covid_nian
SELECT datetime as datetime,
Temperature as Temperature,
Humidity as Humidity,
Rain as Rain,
weekday as weekday,
tested as tested,
positive as positive
FROM weather_covid_nian;

