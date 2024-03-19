package mergestringsalternately

import kotlin.math.min

/**
 * https://leetcode.com/problems/merge-strings-alternately
 */
class Solution {
  fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()
    val short = min(word1.length, word2.length)
    for (i in 0 until short) {
      result
        .append(word1[i])
        .append(word2[i])
    }

    if (word1.length > word2.length) {
      result.append(word1.substring(word2.length))
    }
    if (word1.length < word2.length) {
      result.append(word2.substring(word1.length))
    }
    return result.toString()
  }
}
