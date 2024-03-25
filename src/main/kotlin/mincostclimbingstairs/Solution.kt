package mincostclimbingstairs

import kotlin.math.min

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
class Solution {
  fun minCostClimbingStairs(cost: IntArray): Int {
    val dp = IntArray(2)
    dp[1] = cost[cost.size - 1]
    dp[0] = cost[cost.size - 2]

    for (i in cost.size - 3 downTo 0) {
      val temp = cost[i] + min(dp[0], dp[1])
      dp[1] = dp[0]
      dp[0] = temp
    }

    return min(dp[0], dp[1])
  }
}
