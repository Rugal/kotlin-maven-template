package nonoverlappingintervals

/**
 * https://leetcode.com/problems/non-overlapping-intervals
 */
class Solution {
  fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[1] }

    var count = 0

    for (i in 1 until intervals.size) {
      // start of next event is earlier than the end of previous event
      // so there is overlap
      if (intervals[i][0] < intervals[i - 1][1]) {
        // now we removed the current event, copy the end time to current event
        // as if it is removed
        intervals[i][1] = intervals[i - 1][1]
        ++count
      }
    }
    return count
  }
}
