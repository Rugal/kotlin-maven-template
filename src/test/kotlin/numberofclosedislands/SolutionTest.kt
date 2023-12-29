package numberofclosedislands

import kotlin.test.Test
import org.junit.jupiter.api.Assertions

class SolutionTest {
  val s = Solution()

  /**
    1 1
    1 3
    1 6
    2 7
    8 5
   */
  @Test
  fun test() {

    val g = arrayOf(
      intArrayOf(1, 1, 0, 1, 1, 1, 1, 1, 1, 1),
      intArrayOf(0, 0, 1, 0, 0, 1, 0, 1, 1, 1),
      intArrayOf(1, 0, 1, 0, 0, 0, 1, 0, 1, 0),
      intArrayOf(1, 1, 1, 1, 1, 0, 0, 1, 0, 0),
      intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 1, 0),
      intArrayOf(0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
      intArrayOf(1, 0, 1, 0, 0, 0, 0, 1, 1, 0),
      intArrayOf(1, 1, 0, 0, 1, 1, 0, 0, 0, 0),
      intArrayOf(0, 0, 0, 1, 1, 0, 1, 1, 1, 0),
      intArrayOf(1, 1, 0, 1, 0, 1, 0, 0, 1, 0)
    )

    Assertions.assertEquals(4, s.closedIsland(g))
  }
}
