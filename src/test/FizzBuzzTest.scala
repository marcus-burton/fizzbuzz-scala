import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.util.Random.nextInt

class FizzBuzzTest extends FlatSpec with ShouldMatchers {
  behavior of "Game of FizzBuzz"

  it should "be played for at least 1 round" in {
    FizzBuzz(0) should be(List.empty)
    FizzBuzz(-1) should be(List.empty)
  }

  it should "be played up to a specified number" in {
    val gameLimit = nextInt(testGameLength) + 1
    FizzBuzz(gameLimit) should have length gameLimit
  }

  val testGameLength = 1000
  val gameResults = FizzBuzz(testGameLength)

  it should "say actual number if not divisible by 3 or 5" in {
    assertSaid(!divisibleBy3(_), !divisibleBy5(_), "Number")
  }

  it should "say Fizz if divisible by 3 and not 5" in {
    assertSaid(divisibleBy3(_), !divisibleBy5(_), "Fizz")
  }

  it should "say Buzz if divisible by 5 and not 3" in {
    assertSaid(!divisibleBy3(_), divisibleBy5(_), "Buzz")
  }

  it should "say FizzBuzz if divisible by 3 and 5" in {
    assertSaid(divisibleBy3(_), divisibleBy5(_), "FizzBuzz")
  }

  private def assertSaid(divisibleBy3Filter: (Int) => Boolean, divisibleBy5Filter: (Int) => Boolean, expectedToSay: String) {
    for (i <- 1 to testGameLength filter (divisibleBy3Filter(_)) filter (divisibleBy5Filter(_))) {
      val expected = if (expectedToSay == "Number") i.toString else expectedToSay
      withClue(s"Expected to say $expected at $i") {
        gameResults(i - 1) should be(expected)
      }
    }
  }

  private def divisibleBy3(n: Int): Boolean = n % 3 == 0

  private def divisibleBy5(n: Int): Boolean = n % 5 == 0
}