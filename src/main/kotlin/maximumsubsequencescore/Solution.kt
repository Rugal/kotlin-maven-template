package maximumsubsequencescore

import java.util.PriorityQueue
import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-subsequence-score
 */
class Solution {
  /**
   * @param nums1 get sum of subsequence
   * @param nums2 get minimum value of subsequence
   */
  fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    val sorted = nums1
      .mapIndexed { index, item -> item to nums2[index] }
      .sortedByDescending(Pair<Int, Int>::second)

    // Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
    /*
    1 3 3 2
    2 1 3 4 =>
    
    3 1 3 2
    1 2 3 4
     */

    val q = PriorityQueue<Int>()
    var result: Long = -1
    var sum: Long = 0

    for (i in 0 until k - 1) {
      sum += sorted[i].first
      q.offer(sorted[i].first)
    }


    for (i in k - 1 until sorted.size) {
      q.offer(sorted[i].first)
      sum += sorted[i].first

      result = max(result, sum * sorted[i].second)

      sum -= q.poll()
    }
    return result
  }
}
