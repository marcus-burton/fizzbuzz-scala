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

  it should "say number if not divisible by 3 or 5" in {
    for (i <- 1 to testGameLength filter (!divisibleBy3(_)) filter (!divisibleBy5(_)))
      assertSaid(gameResults, i, i.toString)
  }

  it should "say Fizz if divisible by 3 and not 5" in {
    for (i <- 1 to testGameLength filter (divisibleBy3(_)) filter (!divisibleBy5(_)))
      assertSaid(gameResults, i, "Fizz")
  }

  it should "say Buzz if divisible by 5 and not 3" in {
    for (i <- 1 to testGameLength filter (!divisibleBy3(_)) filter (divisibleBy5(_)))
      assertSaid(gameResults, i, "Buzz")
  }

  it should "say FizzBuzz if divisible by 3 and 5" in {
    for (i <- 1 to testGameLength filter (divisibleBy3(_)) filter (divisibleBy5(_)))
      assertSaid(gameResults, i, "FizzBuzz")
  }

  private def assertSaid(gameResults: List[String], number: Int, expectedToSay: String) {
    withClue(s"Expected to say $expectedToSay at $number") {
      gameResults(number - 1) should be(expectedToSay)
    }
  }

  private def divisibleBy3(n: Int): Boolean = n % 3 == 0

  private def divisibleBy5(n: Int): Boolean = n % 5 == 0
}