package containerwithmostwater

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/container-with-most-water
 */
class Solution {
  fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var result = Int.MIN_VALUE

    while (left < right) {
      result = max(result, min(height[left], height[right]) * (right - left))
      if (height[left] < height[right]) {
        ++left
      } else {
        --right
      }
    }

    return result
  }
}
