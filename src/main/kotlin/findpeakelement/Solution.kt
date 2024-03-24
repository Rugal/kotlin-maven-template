package findpeakelement

/**
 * https://leetcode.com/problems/find-peak-element
 */
class Solution {
  fun findPeakElement(nums: IntArray): Int {
    for (i in nums.indices) {
      if ((i - 1 < 0 || nums[i - 1] < nums[i])
        && (i + 1 >= nums.size || nums[i] > nums[i + 1])) {
        return i
      }
    }
    return -1
  }

  fun findPeakElement_bs(nums: IntArray): Int {
    if (nums.size == 1) return 0

    var left = 0
    var right = nums.size - 1

    while (left <= right) {
      val mid = left + (right - left) / 2
      if ((mid - 1 < 0 || nums[mid - 1] < nums[mid])
        && (mid + 1 >= nums.size || nums[mid] > nums[mid + 1])) {
        return mid
      }

      // (mid + 1 >= nums.size || nums[mid] > nums[mid + 1])
      if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
        right = mid - 1
        continue
      }
      if (mid + 1 < nums.size && nums[mid + 1] > nums[mid]) {
        left = mid + 1
        continue
      }
    }
    return -1
  }
}
