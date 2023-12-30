package constructbinarysearchtreefrompreordertraversal

import kotlin.test.Test

class SolutionTest {
  private val s = Solution()

  @Test
  fun test() {
    s.bstFromPreorder(intArrayOf(8, 5, 1, 7, 10, 12))
  }
}
