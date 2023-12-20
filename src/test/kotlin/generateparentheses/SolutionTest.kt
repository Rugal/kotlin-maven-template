package generateparentheses

import kotlin.test.Test

class SolutionTest {
  private val s = Solution()

  @Test
  fun test() {
    this.s.generateParenthesis(3)
      .forEach(::println)
  }
}
