import scala.collection.mutable.ListBuffer

object FizzBuzz {
  def apply(n: Int): List[String] = {
    val results = new ListBuffer[String]()
    for (i <- 1 to n)
      results += ""
    results.toList
  }
}