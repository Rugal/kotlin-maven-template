package productofarrayexceptself

/**
 * https://leetcode.com/problems/product-of-array-except-self
 */
class Solution {
  fun productExceptSelf(nums: IntArray): IntArray {
    var product = 1
    var zeroCount = 0
    for (i in nums) {
      if (i == 0) {
        ++zeroCount
        continue
      }
      product *= i
    }
    if (zeroCount > 1) {
      return IntArray(nums.size)
    }
    for (i in nums.indices) {
      nums[i] = if (zeroCount > 0) (if (nums[i] == 0) product else 0) else product / nums[i]
    }
    
    return nums
  }
}
