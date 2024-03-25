package besttimetobuyandsellstock

import kotlin.math.max

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
class Solution {
  fun maxProfit(prices: IntArray): Int {
    val dp = IntArray(prices.size)
    dp[prices.size - 1] = prices.last()
    for (i in prices.size - 2 downTo 0) {
      dp[i] = max(dp[i + 1], prices[i])
    }
    var result = Int.MIN_VALUE

    for (i in prices.indices) {
      result = max(result, dp[i] - prices[i])
    }

    return result
  }
}
