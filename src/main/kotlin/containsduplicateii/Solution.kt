package containsduplicateii

import kotlin.math.abs

/**
 * https://leetcode.com/problems/contains-duplicate-ii
 */
class Solution {
  fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, MutableList<Int>>()

    for (i in nums.indices) {
      val list = map.computeIfAbsent(nums[i]) { mutableListOf() }
      if (list.any { abs(it - i) <= k }) return true
      list.add(i)
    }

    return false
  }
}
