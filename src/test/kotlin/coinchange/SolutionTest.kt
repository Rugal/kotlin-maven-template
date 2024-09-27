package coinchange

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {
  private val s = Solution()

  @MethodSource("source")
  @ParameterizedTest
  fun test(coins: IntArray, amount: Int, expected: Int) =
    Assertions.assertEquals(expected, s.coinChange(coins, amount))

  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
      Arguments.of(intArrayOf(1, 2, 5), 11, 3),
      Arguments.of(intArrayOf(2), 3, -1),
      Arguments.of(intArrayOf(1), 0, 0),
    )
  }
}
