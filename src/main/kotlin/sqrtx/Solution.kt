package sqrtx

/**
 * https://leetcode.com/problems/sqrtx/
 */
class Solution {

  /**
   * This is to avoid overflow.
   */
  private fun equality(i: Int, target: Int): Boolean = i <= target / i && (i + 1) > target / (i + 1)

  fun mySqrt(x: Int): Int {
    if (x == 0) return 0

    var left = 1
    var right = x

    while (left <= right) {
      val mid = left + (right - left) / 2

      if (this.equality(mid, x)) return mid

      if (mid < x / mid) {
        left = mid + 1
      } else {
        right = mid
      }
    }

    return left
  }
}
