package wordladder

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun ladderLength() {
    Assertions.assertEquals(5, s.ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
  }
}
