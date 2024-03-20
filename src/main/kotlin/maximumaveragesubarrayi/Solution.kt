package maximumaveragesubarrayi

import kotlin.math.max

/**
 * https://leetcode.com/problems/maximum-average-subarray-i
 */
class Solution {
  fun findMaxAverage(nums: IntArray, k: Int): Double {
    var result = Double.NEGATIVE_INFINITY
    var sum = 0.0

    for (i in 0 until k) {
      sum += nums[i]
    }

    var left = 0
    var right = k - 1
    
    while (right < nums.size) {
      // if has k element in window, calculate average
      if (right - left + 1 == k) {
        result = max(result, 1.0 * sum / k)
      }

      sum -= nums[left++]
      if (++right < nums.size) {
        sum += nums[right]
      }
    }


    return result
  }
}
