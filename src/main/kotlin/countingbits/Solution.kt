package countingbits

/**
 * https://leetcode.com/problems/counting-bits/
 */
class Solution {
  fun countBits(n: Int): IntArray {
    val dp = IntArray(n + 1)

    /*
                1
         2      -        3 
      4  -  5        6   -   7
     8-9  10-11    12-13   14-15
     */
    for (i in 0..n) {
      // reuse previous value, also add by even/odd nature 
      dp[i] = dp[i / 2] + i % 2
    }

    return dp
  }
}
