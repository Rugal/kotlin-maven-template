package binarysearch

class Solution {
  fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
      val mid = (left + right) / 2
      if (nums[mid] == target) return mid
      if (nums[mid] < target) { // should go right
        left = mid + 1
      } else { // should go left
        right = mid - 1
      }
    }
    return -1
  }
}
