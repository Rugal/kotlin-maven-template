package patternStringMatcher

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {
  private val s = Solution()

  @MethodSource("source")
  @ParameterizedTest
  fun test(pattern: String, text: String, expected: Boolean) {
    Assertions.assertEquals(expected, s.patternStr(pattern, text))
  }

  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
      Arguments.of("abba", "北京 杭州 杭州 北京", true),
      Arguments.of("aaba", "北京 杭州 杭州 北京", false),
      Arguments.of("aabb", "北京 北京 杭州 杭州", true),
      Arguments.of("baaa", "北京 杭州 杭州 杭州", true),
      Arguments.of("baaa", "北京 杭州 杭州 北京", false),
    )
  }
}
