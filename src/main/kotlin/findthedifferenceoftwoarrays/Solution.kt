package findthedifferenceoftwoarrays

/**
 * https://leetcode.com/problems/find-the-difference-of-two-arrays
 */
class Solution {
  fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val s1 = nums1.toSet()
    val s2 = nums2.toSet()
    return listOf(s1.subtract(s2).toList(), s2.subtract(s1).toList())
  }
}
