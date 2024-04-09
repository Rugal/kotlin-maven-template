package minimizemaximumdistancetogasstation

/**
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station
 */
class Solution {
  /**
   * @param stations: an integer array
   * @param k: an integer
   * @return: the smallest possible value of D
   */
  fun minmaxGasDist(stations: IntArray, k: Int): Double {
    var left = 0.0
    var right = 1e8
    while (right - left > 1e-6) {
      val mid = (left + right) / 2.0
      if (possible(mid, stations, k))
        right = mid
      else
        left = mid
    }
    return left
  }

  private fun possible(d: Double, stations: IntArray, k: Int): Boolean {
    var used = 0
    for (i in 0 until stations.size - 1)
      used += ((stations[i + 1] - stations[i]) / d).toInt()
    return used <= k
  }
}
