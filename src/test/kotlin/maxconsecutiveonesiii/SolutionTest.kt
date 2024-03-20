package maxconsecutiveonesiii

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  val s = Solution()

  /*
result 5 left 0 right 5
result 5 left 1 right 6
result 8 left 2 right 10
result 8 left 3 right 10
result 8 left 4 right 10
result 8 left 5 right 13
result 8 left 6 right 14
result 8 left 7 right 14
result 8 left 8 right 14
result 8 left 9 right 14
result 8 left 10 right 15
result 8 left 11 right 15
result 8 left 12 right 15
   */
  
/*
result 6 left 0 right 6
result 12 left 1 right 13
result 13 left 2 right 15
 */
  @Test
  fun longestOnes() {
    Assertions.assertEquals(10, s.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
  }
}
