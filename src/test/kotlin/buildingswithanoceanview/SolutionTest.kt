package buildingswithanoceanview

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
  private val s = Solution()

  @Test
  fun findBuildings() {
    Assertions.assertArrayEquals(intArrayOf(0, 2, 3), s.findBuildings(intArrayOf(4, 2, 3, 1)))
    Assertions.assertArrayEquals(intArrayOf(0, 1, 2, 3), s.findBuildings(intArrayOf(4, 3, 2, 1)))
    Assertions.assertArrayEquals(intArrayOf(3), s.findBuildings(intArrayOf(1, 3, 2, 4)))
  }
}
