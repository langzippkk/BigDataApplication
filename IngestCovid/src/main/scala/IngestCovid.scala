
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010._
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.client.Get
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.util.Bytes

object IngestCovid {
  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)
  val hbaseConf: Configuration = HBaseConfiguration.create()
  hbaseConf.set("hbase.zookeeper.property.clientPort", "2181")
  hbaseConf.set("hbase.zookeeper.quorum", "localhost")

  val hbaseConnection = ConnectionFactory.createConnection(hbaseConf)
  val weatherCovid = hbaseConnection.getTable(TableName.valueOf("processed_weather_covid_nian"))
  val latestWeather = hbaseConnection.getTable(TableName.valueOf("latest_weather_nian"))

  def getLatestWeather(date: String) = {
    val result = latestWeather.get(new Get(Bytes.toBytes(date)))
    System.out.println(result.isEmpty())
    if (result.isEmpty())
      None
    else
      Some(WeatherReport(
        date,
        Bytes.toInt(result.getValue(Bytes.toBytes("weather"), Bytes.toBytes("Temperature"))),
        Bytes.toInt(result.getValue(Bytes.toBytes("weather"), Bytes.toBytes("Humidity"))),
        Bytes.toInt(result.getValue(Bytes.toBytes("weather"), Bytes.toBytes("Rain")))))
  }


    def putCovidData(kfr: KafkaCovidRecord): String = {
      val result = getLatestWeather(kfr.date)
      if (result.isEmpty)
        return "No weather for" + kfr.date;
      val result1 = result.get

      var final1 = new Put(Bytes.toBytes(kfr.date))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("Temperature"), Bytes.toBytes(result1.Temperature))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("Humidity"), Bytes.toBytes(result1.Humidity))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("Rain"), Bytes.toBytes(result1.Rain))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("weekday"), Bytes.toBytes(kfr.day))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("tested"), Bytes.toBytes(kfr.peopleTestedTotal))
      final1.addColumn(Bytes.toBytes("weather"), Bytes.toBytes("positive"), Bytes.toBytes(kfr.peoplePositiveTotal))

      weatherCovid.put(final1)
      println(final1)
      return "Updated speed layer for date" + kfr.date
    }


    def main(args: Array[String]) {
      if (args.length < 1) {
        System.err.println(
          s"""
             |Usage: StreamFlights <brokers>
             |  <brokers> is a list of one or more Kafka brokers
             |
        """.stripMargin)
        System.exit(1)
      }

      val Array(brokers) = args

      // Create context with 2 second batch interval
      val sparkConf = new SparkConf().setAppName("StreamCovidApp")
      val ssc = new StreamingContext(sparkConf, Seconds(2))

      // Create direct kafka stream with brokers and topics
      val topicsSet = Set("nian_final_covid")
      // Create direct kafka stream with brokers and topics
      val kafkaParams = Map[String, Object](
        "bootstrap.servers" -> brokers,
        "key.deserializer" -> classOf[StringDeserializer],
        "value.deserializer" -> classOf[StringDeserializer],
        "group.id" -> "use_a_separate_group_id_for_each_stream",
        "auto.offset.reset" -> "latest",
        "enable.auto.commit" -> (false: java.lang.Boolean)
      )
      val stream = KafkaUtils.createDirectStream[String, String](
        ssc, PreferConsistent,
        Subscribe[String, String](topicsSet, kafkaParams)
      )

      // Get the lines, split them into words, count the words and print
      val serializedRecords = stream.map(_.value);

      val kfrs = serializedRecords.map(rec => mapper.readValue(rec, classOf[KafkaCovidRecord]))

      // Update speed table
      val processedFlights = kfrs.map(putCovidData)
      processedFlights.print()
      // Start the computation
      ssc.start()
      ssc.awaitTermination()
    }
}
