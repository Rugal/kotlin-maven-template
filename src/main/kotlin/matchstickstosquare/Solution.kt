package matchstickstosquare

import kotlin.math.pow

/**
 * https://leetcode.com/problems/matchsticks-to-square/description/
 */
class Solution {

  /**
   * @param matchsticks size in 1 until 16
   */
  fun makesquare(matchsticks: IntArray): Boolean {
    val sum = matchsticks.sum()
    // early exit if it can not be divided by 4
    if (sum % 4 != 0) return false

    val map = mutableMapOf<Pair<Int, Int>, Boolean>()

    /**
     * @param remain the remaining length to fulfill
     * @param bitmask current stick usage in bitmask format
     */
    fun solve(index: Int, remain: Int, bitmask: Int): Boolean {
      val p = remain to bitmask
      // early exit if already solved
      if (map.contains(p)) return map[p]!!

      // memoization
      if (remain == 0) { // all edged all satisfied
        // 2 << 15   => 1 0000 0000 0000 0000
        // 2 << 15 - 1 => 1111 1111 1111 1111
        return if (bitmask == 2.0.pow(matchsticks.size).toInt() - 1) true // use all stick
        else solve(0, sum / 4, bitmask) // some edge not satisfied yet
      }

      // unable to form edge correctly || all stick used but still not satisfy 
      if (remain < 0 || index == matchsticks.size) return false

      var flag = false
      for (i in index until matchsticks.size) {
        // this stick not used yet
        if (((1 shl i) and bitmask) == 0) {
          // use this stick, subtract the length from remain, annotate the usage of this stick in bitmask
          flag = solve(i + 1, remain - matchsticks[i], bitmask xor (1 shl i))
        }

        // able to use this stick here to fulfill requirement
        if (flag) {
          map[p] = true
          return true
        }
      }
      // after go through all stick, still not able to fulfill requirement
      map[p] = false
      return false
    }

    return solve(0, sum / 4, 0) // bitmask
  }
}
