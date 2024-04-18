package longestpalindromicsubstring

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
class Solution {
  fun longestPalindrome(s: String): String {
    val dp = Array(s.length) { BooleanArray(s.length) }
    val ans = intArrayOf(0, 0)

    // initialize for single character
    for (i in s.indices) {
      dp[i][i] = true
    }

    // initialize for two characters
    for (i in 0 until s.length - 1) {
      if (s[i] == s[i + 1]) {
        dp[i][i + 1] = true
        ans[0] = i
        ans[1] = i + 1
      }
    }
    // iterate for each length
    for (diff in 2 until s.length) {
      for (i in 0 until s.length - diff) {
        val j = i + diff
        if (s[i] == s[j] && dp[i + 1][j - 1]) {
          dp[i][j] = true
          ans[0] = i
          ans[1] = j
        }
      }
    }

    return s.substring(ans[0], ans[1] + 1)
  }
}
