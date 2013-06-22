import scala.collection.mutable.ListBuffer

object FizzBuzz {
  def apply(n: Int): List[String] = {
    val results = new ListBuffer[String]()
    for (i <- 1 to n) {
      i match {
        case _ if divisibleBy3(i) && divisibleBy5(i) => results += "FizzBuzz"
        case _ if divisibleBy3(i) => results += "Fizz"
        case _ if divisibleBy5(i) => results += "Buzz"
        case _ => results += i.toString
      }
    }
    results.toList
  }

  private def divisibleBy3(n: Int): Boolean = n % 3 == 0

  private def divisibleBy5(n: Int): Boolean = n % 5 == 0
}