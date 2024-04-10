package evaluatedivision

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/evaluate-division
 */
class Solution {

  private fun build(equations: List<List<String>>, values: DoubleArray): Map<String, Map<String, Double>> =
    mutableMapOf<String, MutableMap<String, Double>>().also {
      for (i in equations.indices) {
        it.computeIfAbsent(equations[i][0]) { mutableMapOf() }[equations[i][1]] = values[i]
        it.computeIfAbsent(equations[i][1]) { mutableMapOf() }[equations[i][0]] = 1.0 / values[i]
      }
    }

  private fun query(g: Map<String, Map<String, Double>>, pair: List<String>): Double {
    if (!g.containsKey(pair[0]) || !g.containsKey(pair[1])) {
      return -1.0
    }
    val q: Queue<Pair<String, Double>> = LinkedList()
    val visited = mutableSetOf<String>()
    q.offer(pair[0] to 1.0)

    while (q.isNotEmpty()) {
      val poll = q.poll()
      // if find the target
      if (poll.first == pair[1]) {
        return poll.second
      }

      // this node is visited now
      visited.add(poll.first)
      // should be a valid node
      if (!g.contains(poll.first)) continue
      
      for (n in g[poll.first]!!.entries) {
        if (!visited.contains(n.key)) {
          q.offer(n.key to n.value * poll.second)
        }
      }
    }

    return -1.0
  }

  /**
   * It is basically a graph reachability problem. Create directed graph.
   */
  fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
    val g: Map<String, Map<String, Double>> = this.build(equations, values)
    return queries.map { this.query(g, it) }.toDoubleArray()
  }
}
