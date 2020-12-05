
create table weather_covid_nian (
      datetime string,
      Temperature float,
      Humidity float,
      Rain float,
      weekday STRING,
      tested INT,
      Day INT) stored as orc;


insert overwrite table weather_covid_nian
  select weather_nian.datetime as datetime, weather_nian.Temperature as Temperature, 
  weather_nian.Humidity as Humidity, weather_nian.Rain as Rain, 
  covid_nian.weekday as weekday, covid_nian.tested as tested,
  covid_nian.positive as positive,
  from weather_nian JOIN COVID_nian
  on COVID_nian.datetime = weather_nian.datetime;