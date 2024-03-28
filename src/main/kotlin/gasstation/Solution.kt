package gasstation

/**
 * https://leetcode.com/problems/gas-station
 */
class Solution {
  fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0 // total surplus
    var surplus = 0 // current surplus
    var start = 0
    for (i in gas.indices) {
      val s = gas[i] - cost[i]
      total += s // accumulate for all trip
      surplus += s // acculumate for current trip
      if (surplus < 0) { // we have to stop here
        start = i + 1 // start from next gas station
        surplus = 0 // reset as we start over
      }
    }

    return if (total < 0) -1 else start
  }
}
