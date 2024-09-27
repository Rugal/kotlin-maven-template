package twosum

/**
 * https://leetcode.com/problems/two-sum/
 */
class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val m = nums.mapIndexed { index, i -> i to index }.toMap()

    for (i in nums.indices) {
      val remainder = target - nums[i]
      if (m.containsKey(remainder) && i != m[remainder]) return intArrayOf(i, m[remainder]!!)
    }

    return intArrayOf()
  }
}
