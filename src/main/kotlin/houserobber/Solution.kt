package houserobber

import kotlin.math.max

/**
 * https://leetcode.com/problems/house-robber
 */
class Solution {
  fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]

    var twoBefore = 0
    var oneBefore = nums[0]

    for (i in 1 until nums.size) {
      val current = max(twoBefore + nums[i], oneBefore)
      twoBefore = oneBefore
      oneBefore = current
    }
    return oneBefore
  }
}
