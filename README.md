Final Project for MPCS 53014 taught by Prof. Michael Spertus


About this APP

	This is a big data application that stream Covid data from Chicago area
	and join it with weather data by manually submit from web form. And the weather data is different from what we used in the class. It includes:
	Temperature:Int,Humidity:Int,Rain:Int


	In the check-covid.html, you could check the data by entering the date.
	In the submit-weather.html, you could submit the latest weather data by date.

	Notice that the data will only update once you both submit the weather and also the Covid website has updated their data.


How to run this BigDataApplication:

	1. Open the website that has been deployed to LoadBalancer on Amazon:

		submit weather: http://mpcs53014-loadbalancer-217964685.us-east-2.elb.amazonaws.com:3181/submit-weather.html
		query covid data: http://mpcs53014-loadbalancer-217964685.us-east-2.elb.amazonaws.com:3181/check-covid.html

	2. Run the .jar file for streaming weather data from form:
		spark-submit --master local[2] --class StreamWeather nian/1_WeatherSpeedLayer/target/uber-SpeedLayer-1.0-SNAPSHOT.jar b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092

	3. Run the .jar file for streaming covid data from website:
		java -cp nian/2_StreamCovid/target/uber-Speedlayercovid-1.0-SNAPSHOT.jar org.example.RealTimeCovid b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092

	4. Run the .jar file for reading data from kafka and writing to Hbase:
		spark-submit --master local[2] --class IngestCovid nian/3_IngestCovidWeather/target/uber-IngestCovid-1.0-SNAPSHOT.jar b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092


Step by Step instruction(already done):

	1.Download CSV data from website and change the name to weather.csv
	and COVID.csv:

	Weather data:
		https://data.cityofchicago.org/Parks-Recreation/Beach-Weather-Stations-Automated-Sensors/k7hf-8y75

	Covid data:
		https://data.cityofchicago.org/Health-Human-Services/COVID-19-Daily-Testing-By-Person/t4hh-4ku9

	Weather and covid data are available in this folder.


	2. Preprocess csv file using python and pandas(need to put .py in the same directory with .csv file):

	Weather data:
		preprocess_weather.py

	Covid data:
		preprocess_covid.py

	processed data are available in this folder.

	3.Copy data from local to cluster(already in cluster: /nian)

		scp -i nian.pem ~/Desktop/BIGDATAFINAL/weather+covid/COVID_processed.csv hadoop@ec2-52-15-169-10.us-east-2.compute.amazonaws.com:~/nian

		scp -i nian.pem ~/Desktop/BIGDATAFINAL/weather+covid/weather_processed.csv hadoop@ec2-52-15-169-10.us-east-2.compute.amazonaws.com:~/nian


	4.Put data to hdfs

		hdfs dfs -put ./nian/weather_processed.csv /tmp/nian/weather_nian
		hdfs dfs -put ./nian/COVID_processed.csv /tmp/nian/covid_nian


	5.Go to beeline, create weather and covid table by running hql file: 	 	 create_weather.hql
		create_COVID.hql
		create_covid_weather.hql

	6.Go to Hbase, create Hbase by command:

		create 'processed_weather_covid_nian','weather'

	7.Create topic for Kafka:

		1.	Go to Kafka executable

			cd kafka_2.12-2.2.1/bin

		2.	Create a topic named  nian_final for stream weather

		./kafka-topics.sh --create --zookeeper z-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181,z-3.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181,z-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181 --replication-factor 2 --partitions 1 --topic nian_final

		3.  Create a topic named nian_final_covid

		./kafka-topics.sh --create --zookeeper z-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181,z-3.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181,z-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:2181 --replication-factor 2 --partitions 1 --topic nian_final_covid

	8.Creating Hbase table for streaming weather

		create 'latest_weather_nian','weather'

	9.Deploy the webserver folder to LoadBalancer with port 3181

	10.Maven install the SpeedLayerWeather and deploy to cluster.
	Run it by:

		spark-submit --master local[2] --class StreamWeather nian/1_WeatherSpeedLayer/target/uber-SpeedLayer-1.0-SNAPSHOT.jar b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092

	11. We can check the speedlayer of weather data by checking the Hbase:

		get 'latest_weather_nian','12/05/2020'

	12. Maven install the SpeedLayerCovid and deploy to cluster.
	Run it by:

		java -cp nian/2_StreamCovid/target/uber-Speedlayercovid-1.0-SNAPSHOT.jar org.example.RealTimeCovid b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092

	13. Maven install the IngestCovid and deploy to cluster.
	Run it by:

		spark-submit --master local[2] --class IngestCovid nian/3_IngestCovidWeather/target/uber-IngestCovid-1.0-SNAPSHOT.jar b-2.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092,b-1.mpcs53014-kafka.fwx2ly.c4.kafka.us-east-2.amazonaws.com:9092








