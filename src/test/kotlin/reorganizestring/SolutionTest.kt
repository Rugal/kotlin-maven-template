package reorganizestring

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun reorganizeString() {
    Assertions.assertEquals("ababababab", s.reorganizeString("abbabbaaab"))
  }
}
