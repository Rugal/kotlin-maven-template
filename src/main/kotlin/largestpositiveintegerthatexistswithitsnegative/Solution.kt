package largestpositiveintegerthatexistswithitsnegative

import kotlin.math.abs
import kotlin.math.max

/**
 * https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
 */
class Solution {
  fun findMaxK(nums: IntArray): Int {
    val set = mutableSetOf<Int>()
    var result = -1

    for (i in nums) {
      set += i
      // both exist
      if (set.contains(-1 * i)) {
        // record if more than current result
        result = max(result, abs(i))
      }
    }
    return result
  }
}
