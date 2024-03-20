package findthehighestaltitude

import kotlin.math.max

/**
 * https://leetcode.com/problems/find-the-highest-altitude
 */
class Solution {
  fun largestAltitude(gain: IntArray): Int {
    var altitude = 0
    var result = 0

    for (i in gain) {
      altitude += i
      result = max(result, altitude)
    }

    return result
  }
}
