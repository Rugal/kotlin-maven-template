package coursescheduleii

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/course-schedule-ii/
 */
class Solution {
  fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val g = Graph(numCourses)
    for (p in prerequisites) {
      g.add(p[1], p[0])
    }

    val q: Queue<Int> = LinkedList(g.inDegree.withIndex().filter { it.value == 0 }.map { it.index })
    val result = mutableListOf<Int>()
    var n = numCourses

    while (q.isNotEmpty()) {
      val poll = q.poll()
      // add to prerequisite list
      result.add(poll)
      --n

      g.adjacency[poll].filter { 0 == --g.inDegree[it] }.forEach(q::offer)
    }

    return if (n == 0) result.toIntArray() else intArrayOf()
  }
}

private class Graph(val n: Int) {
  val inDegree = IntArray(n) { 0 }
  val adjacency = Array<Queue<Int>>(n) { LinkedList() }

  fun add(from: Int, to: Int) {
    ++this.inDegree[to]
    this.adjacency[from].offer(to)
  }
}
