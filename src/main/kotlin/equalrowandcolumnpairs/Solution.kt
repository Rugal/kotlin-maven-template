package equalrowandcolumnpairs

/**
 * https://leetcode.com/problems/equal-row-and-column-pairs
 */
class Solution {
  fun equalPairs(grid: Array<IntArray>): Int {

    val m1 = mutableMapOf<String, Int>().also {
      for (r in grid) {
        val key = r.joinToString(separator = "-")
        it[key] = it.getOrDefault(key, 0) + 1
      }
    }

    val m2 = mutableMapOf<String, Int>().also {
      for (c in 0 until grid[0].size) {
        val sb = StringBuilder()
        for (r in grid.indices) {
          if (r > 0) {
            sb.append("-")
          }
          sb.append("${grid[r][c]}")
        }
        val key = sb.toString()
        it[key] = it.getOrDefault(key, 0) + 1
      }
    }

    var result = 0

    for (i in m1.entries) {
      if (!m2.containsKey(i.key)) {
        continue
      }

      result += m2[i.key]!! * i.value
    }
    return result
  }
}
