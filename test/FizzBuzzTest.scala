import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.util.Random.nextInt

class FizzBuzzTest extends FlatSpec with ShouldMatchers {
  behavior of "Game of FizzBuzz"

  val testGameLength = 1000

  it should "play up to a specified limit" in {
    val gameLimit = randomGameLengthUpTo(2)
    FizzBuzz(gameLimit) should have length gameLimit
  }

  it should "say number if not divisible by 3 or 5" in {
    val game = FizzBuzz(testGameLength)
    for (i <- 1 to testGameLength filter (divisibleBy3(_)) filter (divisibleBy5(_)))
      game(i - 1) should be(i.toString)
  }

  def divisibleBy3(n: Int): Boolean = n % 3 != 0

  def divisibleBy5(n: Int): Boolean = n % 5 != 0

  def randomGameLengthUpTo(n: Int): Int = nextInt(n)
}