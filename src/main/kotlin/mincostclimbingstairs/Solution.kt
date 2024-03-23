package mincostclimbingstairs

import kotlin.math.min

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
class Solution {
  fun minCostClimbingStairs(cost: IntArray): Int {
    val dp = IntArray(cost.size) { Int.MAX_VALUE }
    dp[cost.size - 1] = cost[cost.size - 1]
    dp[cost.size - 2] = cost[cost.size - 2]

    for (i in cost.size - 3 downTo 0) {
      dp[i] = cost[i] + min(dp[i + 1], dp[i + 2])
    }
    
    return min(dp[0], dp[1])
  }
}
