package coinchangeii

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  private val s = Solution()

  @MethodSource("source")
  @ParameterizedTest
  fun test(coins: IntArray, amount: Int, expected: Int) {
    Assertions.assertEquals(expected, s.change(amount, coins))
  }

  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
      Arguments.of(intArrayOf(1, 2, 5), 5, 4),
      Arguments.of(intArrayOf(3), 2, 0),
      Arguments.of(intArrayOf(10), 10, 1),
    )
  }
}
