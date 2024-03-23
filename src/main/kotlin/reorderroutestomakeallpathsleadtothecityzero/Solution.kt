package reorderroutestomakeallpathsleadtothecityzero

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 */
class Solution {
  fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (r in connections) {
      map.computeIfAbsent(r[0]) { mutableListOf() }.add(r[1]) // r[0] -> r[1]
      map.computeIfAbsent(r[1]) { mutableListOf() }.add(-1 * r[0]) // r[1] -> r[0]
    }
    
    /*
      0: 1, -2
      1: 0
      2: 0, -3
      3: 2
     */

    // [[0,1],[2,0],[3,2]]
    val visited = BooleanArray(n)
    var count = 0

    val q: Queue<Int> = LinkedList()
    q.offer(0)
    visited[0] = true

    while (q.isNotEmpty()) {
      val from = q.poll()
      if (!map.containsKey(from)) continue

      for (i in map[from]!!) {
        // if already visited
        if (visited[abs(i)]) continue
        // count those that from parent to child
        if (i > 0) {
          ++count
        }
        // record visitation
        visited[abs(i)] = true
        // next level
        q.offer(abs(i))
      }
    }

    return count
  }
}
