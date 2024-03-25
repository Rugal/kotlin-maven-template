package uniquepaths

import kotlin.math.min

/**
 * https://leetcode.com/problems/unique-paths
 */
class Solution {
  /**
   * math combinatorics problem.
   */
  fun uniquePaths(m: Int, n: Int): Int {
    // must make m - 1 down, n - 1 right steps
    // in total m + n - 2 steps
    // in this many steps, need to pick n - 1 places to go right
    /*
       aCb =   a x (a-1) x (a-2) x....x (a - b + 1)
              --------------------------------
               b x (b-1) x (b-2) x....1
     */

    var total = m + n - 2
    val min = min(m - 1, n - 1)
    var result: Long = 1

    for (i in 1..min) {
      result *= total--
      result /= i
    }

    return result.toInt()
  }
}
