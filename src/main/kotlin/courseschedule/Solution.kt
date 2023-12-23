package courseschedule

import java.util.LinkedList

class Solution {
  fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val g = Graph(numCourses)
    prerequisites.forEach { g.add(it[1], it[0]) }

    var n = numCourses

    val queue = LinkedList<Int>(g.inDegree.withIndex().filter { it.value == 0 }.map { it.index })

    while (queue.isNotEmpty()) {
      n--
      // for each node, find its adjacent nodes, reduce in degree by one as we remove it
      println(queue.peek())
      g.adjacency[queue.poll()].forEach {
        // if in degree is 0, means there is no in bound at all, this adjacent node is outgoing only

        if (0 == --g.inDegree[it]) {
          // we will check this node in next round
          queue.offer(it)
        }
      }
    }
    // only if all nodes are gone, means there is no residual
    return n == 0
  }
}

private class Graph(private val n: Int) {
  val inDegree: IntArray = IntArray(this.n) { 0 }
  val adjacency: Array<LinkedList<Int>> = Array(this.n) { LinkedList() }

  fun add(from: Int, to: Int) {
    this.inDegree[to]++
    this.adjacency[from].add(to)
  }
}
