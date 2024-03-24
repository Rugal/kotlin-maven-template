package guessnumberhigherorlower

/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return       -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

abstract class GuessGame {
  fun guess(num: Int): Int = 0

  abstract fun guessNumber(n: Int): Int
}

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower
 */
class Solution : GuessGame() {
  override fun guessNumber(n: Int): Int {
    var left = 1
    var right = n
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (0 == this.guess(mid)) return mid

      if (0 < this.guess(mid)) {
        // should be larger
        left = mid + 1
      } else {
        // should be smaller
        right = mid - 1
      }
    }

    return -1
  }
}
