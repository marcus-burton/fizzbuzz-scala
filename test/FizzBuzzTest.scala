import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.util.Random.nextInt

class FizzBuzzTest extends FlatSpec with ShouldMatchers {
  behavior of "Game of FizzBuzz"

  val testGameLength = 1000
  val game = FizzBuzz(testGameLength)

  it should "play up to a specified limit" in {
    val gameLimit = randomGameLengthUpTo(2)
    FizzBuzz(gameLimit) should have length gameLimit
  }

  it should "say number if not divisible by 3 or 5" in {
    for (i <- 1 to testGameLength filter (!divisibleBy3(_)) filter (!divisibleBy5(_)))
      withClue(s"For round at $i") {
        game(i - 1) should be(i.toString)
      }
  }

  it should "say Fizz if divisible by 3 and not 5" in {
    for (i <- 1 to testGameLength filter (divisibleBy3(_)) filter (!divisibleBy5(_)))
      withClue(s"For round at $i") {
        game(i - 1) should be("Fizz")
      }
  }

  it should "say Buzz if divisible by 5 and not 3" in {
    for (i <- 1 to testGameLength filter (!divisibleBy3(_)) filter (divisibleBy5(_)))
      withClue(s"For round at $i") {
        game(i - 1) should be("Buzz")
      }
  }

  private def divisibleBy3(n: Int): Boolean = n % 3 == 0

  private def divisibleBy5(n: Int): Boolean = n % 5 == 0

  private def randomGameLengthUpTo(n: Int): Int = nextInt(n)
}