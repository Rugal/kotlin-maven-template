package maximumproductsubarray

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
class Solution {
  fun maxProduct(nums: IntArray): Int {
    var result = nums[0]
    var maximum = result
    var minimum = result

    for (i in 1 until nums.size) {
      // negative value would revert the min and max
      if (nums[i] < 0) {
        maximum = maximum xor minimum
        minimum = maximum xor minimum
        maximum = maximum xor minimum
      }
      maximum = max(nums[i], maximum * nums[i])
      minimum = min(nums[i], minimum * nums[i])

      result = max(result, maximum)
    }

    return result
  }
}
