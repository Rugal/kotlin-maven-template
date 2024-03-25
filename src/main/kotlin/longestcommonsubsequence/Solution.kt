package longestcommonsubsequence

import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-common-subsequence
 */
class Solution {
  fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

    for (r in 1..text1.length) {
      for (c in 1..text2.length) {
        dp[r][c] = (if (text1[r - 1] == text2[c - 1]) dp[r - 1][c - 1] + 1 else max(dp[r][c - 1], dp[r - 1][c]))
      }
    }

    return dp[text1.length][text2.length]
  }
}
