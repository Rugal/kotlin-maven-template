package singlenumber

/**
 * https://leetcode.com/problems/single-number
 */
class Solution {
  fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (n in nums) result = result xor n
    return result
  }
}
