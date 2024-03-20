package findpivotindex

/**
 * https://leetcode.com/problems/find-pivot-index/
 */
class Solution {
  fun pivotIndex(nums: IntArray): Int {
    val total = nums.sum()
    var sum = 0
    for (i in nums.indices) {
      if (total - nums[i] == 2 * sum) return i
      sum += nums[i]
    }

    return -1
  }
}
