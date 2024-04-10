package amazonacademy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun minimumNumberOfPages() {
    Assertions.assertEquals(4, s.minimumNumberOfPages(arrayOf(2, 3, 4, 5), 5))
  }
}
