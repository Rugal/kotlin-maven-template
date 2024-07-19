package dominoandtrominotiling

const val MOD: Int = 1000000007

/**
 * https://leetcode.com/problems/domino-and-tromino-tiling
 */
class Solution {
  fun numTilings(n: Int): Int {
    // initialize the first 4 setup's configuration number
    val data = longArrayOf(0, 1, 2, 5)
    if (n <= 3) return data[n].toInt()

    for (i in 4..n) {
      // key: dp[i] = 2 * dp[i-1] + dp[i-3]
      val next: Long = (2 * data[3] + data[1]) % MOD // must use long to avoid overflow
      data[0] = data[1]
      data[1] = data[2]
      data[2] = data[3]
      data[3] = next
    }
    return data[3].toInt()
  }
}
