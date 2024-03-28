package longestconsecutivesequence

import kotlin.math.max

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class Solution {
  fun longestConsecutive(nums: IntArray): Int {
    val set = nums.toSet()
    var result = 0
    for (n in nums) {
      // if the one to its left is already counted, means current is the new left bound
      if (set.contains(n - 1)) continue
      var right = n + 1
      while (set.contains(right)) ++right
      result = max(result, right - n)
    }

    return result
  }
}
