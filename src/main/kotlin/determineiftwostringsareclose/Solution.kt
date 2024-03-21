package determineiftwostringsareclose

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close
 */
class Solution {
  private val String.frequency: Map<Char, Int>
    get() {
      val m = mutableMapOf<Char, Int>()
      for (i in this) {
        m[i] = 1 + m.getOrDefault(i, 0)
      }
      return m
    }

  fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length) return false

    val f1 = word1.frequency
    val f2 = word2.frequency

    return f1.keys == f2.keys && f1.values.toList().sorted() == f2.values.toList().sorted()
  }
}
