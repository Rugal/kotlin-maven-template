package movezeroes

class Solution {
  fun moveZeroes(nums: IntArray) {
    var index = 0
    var current = 0
    while (current < nums.size) {
      if (nums[current] != 0) {
        val temp = nums[index]
        // if is nums[index] is zero, it is replaced with non-zero
        // otherwise, index == current, so they will both increment
        nums[index++] = nums[current]
        nums[current] = temp
      }

      // move right regardless of zero-ness
      ++current
    }
  }
}
