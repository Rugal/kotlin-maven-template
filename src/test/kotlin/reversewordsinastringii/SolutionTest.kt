package reversewordsinastringii

import org.junit.jupiter.api.Test

class SolutionTest {

  val s = Solution()

  @Test
  fun reverseWords() {
    val c = "Rugal Bernstein".toCharArray()
    s.reverseWords(c)
    println(c)
  }
}
