import scala.reflect.runtime.universe._


case class KafkaCovidRecord(
                          date: String,
                          day: String,
                          peopleTestedTotal: Int,
                          peoplePositiveTotal: Int)