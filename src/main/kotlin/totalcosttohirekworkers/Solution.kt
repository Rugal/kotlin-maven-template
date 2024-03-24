package totalcosttohirekworkers

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/total-cost-to-hire-k-workers
 */
class Solution {

  fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    val leftQueue = PriorityQueue<Int>()
    val rightQueue = PriorityQueue<Int>()
    var left = 0
    var right = costs.size - 1

    var result = 0L

    for (i in 0 until k) {
      while (leftQueue.size < candidates && left <= right) leftQueue.offer(costs[left++])
      while (rightQueue.size < candidates && left <= right) rightQueue.offer(costs[right--])

      // to avoid empty queue operation
      val a = if (leftQueue.isNotEmpty()) leftQueue.peek() else Int.MAX_VALUE
      val b = if (rightQueue.isNotEmpty()) rightQueue.peek() else Int.MAX_VALUE
      if (a <= b) {
        result += a
        leftQueue.poll()
      } else {
        result += b
        rightQueue.poll()
      }
    }
    return result
  }
}
