import scala.collection.mutable.ListBuffer

object FizzBuzz {
  def apply(n: Int): List[String] = {
    val results = new ListBuffer[String]()
    for (i <- 1 to n) {
      i match {
        case _ if i % 3 == 0 => results += "Fizz"
        case _ => results += i.toString
      }
    }
    results.toList
  }
}