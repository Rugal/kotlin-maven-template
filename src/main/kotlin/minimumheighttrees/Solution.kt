package minimumheighttrees

import java.util.LinkedList

/**
 * https://leetcode.com/problems/minimum-height-trees
 */
class Solution {
  fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (1 == n) return listOf(0)

    val g = Graph(n)
    for (e in edges) g.add(e[0], e[1])

    val queue = LinkedList(g.inDegree.withIndex().filter { it.value == 1 }.map { it.index })

    var result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
      // BFS
      val size = queue.size
      // reset result for each level until the last one, as it will not be reset anymore
      result = mutableListOf()

      for (i in 0 until size) {
        val node = queue.poll()
        result.add(node)
        --g.inDegree[node] // decrease current node inDegree
        g.adjacency[node]!!.forEach {
          // if in degree is 0, means there is no in bound at all, this adjacent node is outgoing only

          if (1 == --g.inDegree[it]) {
            // we will check this node in next round
            queue.offer(it)
          }
        }
      }
    }
    return result
  }
}

private class Graph(n: Int) {
  val inDegree: IntArray = IntArray(n) { 0 }
  val adjacency: MutableMap<Int, LinkedList<Int>> = mutableMapOf()

  fun add(from: Int, to: Int) {
    // add both node since this is an undirected graph
    this.inDegree[to]++
    this.inDegree[from]++

    this.adjacency.computeIfAbsent(from) { LinkedList<Int>() }.add(to)

    this.adjacency.computeIfAbsent(to) { LinkedList<Int>() }.add(from)
  }
}
