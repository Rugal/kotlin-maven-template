package lengthofthelongestvalidsubstring

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/length-of-the-longest-valid-substring/
 */
class Solution {
  fun longestValidSubstring(word: String, forbidden: List<String>): Int {
    val f = forbidden.toSet()
    var result = 0
    var right = word.length - 1

    for (left in word.length - 1 downTo 0) {
      for (k in left until min(left + 10, right + 1)) {
        if (f.contains(word.substring(left, k + 1))) {
          right = k - 1
          break
        }
      }
      result = max(result, right - left + 1)
    }
    return result
  }
}
