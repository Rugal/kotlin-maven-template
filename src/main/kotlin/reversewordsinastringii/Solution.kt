package reversewordsinastringii

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 */
class Solution {
  private fun reverse(s: CharArray, begin: Int, end: Int) {
    for (i in 0 .. (end - begin) / 2) {
      val t = s[begin + i]
      s[begin + i] = s[end - i]
      s[end - i] = t
    }
  }

  fun reverseWords(s: CharArray): Unit {
    this.reverse(s, 0, s.size - 1)

    var begin = 0
    for (end in s.indices) {
      if (s[end] != ' ') continue
      reverse(s, begin, end - 1)
      begin = end + 1
    }
    reverse(s, begin, s.size - 1)
  }
}
