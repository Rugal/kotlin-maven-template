package courseschedule

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {
  private val s = Solution()

  @ParameterizedTest
  @MethodSource("source")
  fun test(numCourses: Int, prerequisites: Array<IntArray>, expected: Boolean) {
    Assertions.assertEquals(expected, s.canFinish(numCourses, prerequisites))
  }

  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
      Arguments.of(2, arrayOf(intArrayOf(1, 0)), true),
    )
  }
}
