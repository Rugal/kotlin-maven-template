package amazondeliverycenter

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun suitableLocations() {
    Assertions.assertEquals(3, s.suitableLocations(arrayOf(-2, 1, 0), 8))
  }
}
