package missingnumber

class Solution {
  fun missingNumber(nums: IntArray): Int = nums.size * (nums.size + 1) / 2 - nums.reduce { acc, i -> acc + i }
}
