package longestsubstringwithoutrepeatingcharacters

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {

  private val s = Solution()

  @MethodSource("source")
  @ParameterizedTest
  fun test(text: String, expected: Int) {
    Assertions.assertEquals(expected, s.lengthOfLongestSubstring(text))
  }

  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
//      Arguments.of("abcabcbb", 3),
//      Arguments.of("bbbbb", 1),
      Arguments.of("pwwkew", 2),
    )
  }
}
