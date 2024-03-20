package maxconsecutiveonesiii

import kotlin.math.max

class Solution {
  fun longestOnes(nums: IntArray, k: Int): Int {
    var result = 0

    var left = 0
    var right = 0

    var count = 0
    // moving right pointer till we got enough zero within
    while (count < k && right < nums.size) {
      if (nums[right++] == 0) {
        ++count
      }
    }
    // now we have k many zero within left~right range, but there could be more 1 after right
    // try to move right if there is more 1 available, stop on either the end or 0
    while (right < nums.size) {
      if (nums[right] == 0) break
      ++right
    }


    while (right < nums.size) {
      if (count == k) {
        result = max(result, right - left)
      }

      // try to slide to next position
      if (nums[left++] == 0) {
        --count
      }
      while (count < k && right < nums.size) {
        if (nums[right++] == 0) {
          ++count
        }
      }
      while (right < nums.size) {
        if (nums[right] == 0) break
        ++right
      }
    }
    result = max(result, right - left)
    return result
  }
}
