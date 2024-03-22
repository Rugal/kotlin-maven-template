package decodestring

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SolutionTest {
  companion object {
    @JvmStatic
    fun source(): Stream<Arguments> = Stream.of(
      Arguments.of("3[z]2[2[y]pq4[2[jk]e1[f]]]ef", "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"),
    )
  }

  private val s = Solution()

  @ParameterizedTest
  @MethodSource("source")
  fun test(input: String, expected: String) {
    Assertions.assertEquals(expected, s.decodeString(input))
  }
}
