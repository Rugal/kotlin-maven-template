package increasingtripletsubsequence

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence
 */
class Solution {

  fun increasingTriplet(nums: IntArray): Boolean {
    var a = Int.MAX_VALUE
    var b = Int.MAX_VALUE
    for (n in nums) {
      if (n <= a) {
        // smallest value ever encountered
        a = n
        continue
      }
      // if larger than a
      if (n <= b) {
        // second smallest value
        b = n
        continue
      }
      // larger than second number
      return true
    }
    return false
  }
}
