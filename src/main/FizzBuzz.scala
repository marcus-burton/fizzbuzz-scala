object FizzBuzz {
  def apply(gameLimit: Int): List[String] = {
    (1 to gameLimit).map(fizzBuzzConversion).toList
  }

  private def fizzBuzzConversion(i: Int): String = i match {
    case _ if divisibleBy3(i) => if (divisibleBy5(i)) "FizzBuzz" else "Fizz"
    case _ if divisibleBy5(i) => "Buzz"
    case _ => i.toString
  }

  private def divisibleBy3(i: Int): Boolean = i % 3 == 0

  private def divisibleBy5(i: Int): Boolean = i % 5 == 0
}