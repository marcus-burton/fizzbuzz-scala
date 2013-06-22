import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import scala.util.Random.nextInt

class FizzBuzzTest extends FlatSpec with ShouldMatchers {
  behavior of "Game of FizzBuzz"

  it should "play up to a specified limit" in {
    val gameLimit = randomGameLengthUpTo(2)
    FizzBuzz(gameLimit) should have length gameLimit
  }

  def randomGameLengthUpTo(n: Int): Int = {
    nextInt(n)
  }
}