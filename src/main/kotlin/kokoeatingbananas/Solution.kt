package kokoeatingbananas

/**
 * https://leetcode.com/problems/koko-eating-bananas
 */
class Solution {
  private fun eat(piles: IntArray, h: Int, speed: Int): Boolean {
    var result = 0
    for (it in piles) {
      result += (if (it % speed == 0) it / speed else it / speed + 1)
      if (result > h) return false // have to early exit due to overflow
    }
    return true
  }

  fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = piles.max()

    while (left <= right) {
      val mid = left + (right - left) / 2
      if (this.eat(piles, h, mid)) {
        right = mid - 1
      } else {
        left = mid + 1
      }
    }
    return right + 1
  }
}
