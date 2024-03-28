package mergeintervals

import kotlin.math.max

/**
 * https://leetcode.com/problems/merge-intervals
 */
class Solution {

  /**
   * @param intervals [[1,3],[2,6],[8,10],[15,18]]
   */
  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortWith { a, b -> if (a[0] != b[0]) a[0] - b[0] else a[1] - b[1] }
    val result = mutableListOf<IntArray>()

    var left = intervals[0][0]
    var right = intervals[0][1]
    for (i in 1 until intervals.size) {
      if (right < intervals[i][0]) {
        result.add(intArrayOf(left, right))
        left = intervals[i][0]
        right = intervals[i][1]
      } else {
        right = max(right, intervals[i][1])
      }
    }
    result.add(intArrayOf(left, right))

    return result.toTypedArray()
  }
}
