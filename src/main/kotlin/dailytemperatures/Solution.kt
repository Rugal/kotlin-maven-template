package dailytemperatures

import java.util.Stack

/**
 * https://leetcode.com/problems/daily-temperatures
 */
class Solution {
  fun dailyTemperatures(temperatures: IntArray): IntArray {
    // index & temperature
    val result = IntArray(temperatures.size)
    val s = Stack<Pair<Int, Int>>()
    for (i in temperatures.size - 1 downTo 0) {
      if (s.isEmpty()) {
        s.push(i to temperatures[i])
        continue
      }

      if (temperatures[i] < s.peek().second) {
        result[i] = s.peek().first - i
        s.push(i to temperatures[i])
        continue
      }
      // this temperature is high, pop all temperature that is LE it
      while (s.isNotEmpty() && temperatures[i] >= s.peek().second) {
        s.pop()
      }
      // find the next temperature that is greater than it
      if (s.isNotEmpty()) {
        result[i] = s.peek().first - i
      }
      // if not found, leave it 0
      // add this temperature to stack
      s.push(i to temperatures[i])
    }

    return result
  }
}
