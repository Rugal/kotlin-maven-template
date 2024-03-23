package rottingoranges

import java.util.LinkedList

private val DIRECTION = arrayOf(
  intArrayOf(1, 0),
  intArrayOf(-1, 0),
  intArrayOf(0, 1),
  intArrayOf(0, -1),
)

/**
 * https://leetcode.com/problems/rotting-oranges
 */
class Solution {
  private fun isValid(grid: Array<IntArray>, next: Pair<Int, Int>): Boolean =
    next.first in grid.indices
      && next.second in grid[0].indices
      && grid[next.first][next.second] == 1

  fun orangesRotting(grid: Array<IntArray>): Int {
    val rotten = LinkedList<Pair<Int, Int>>()
    val fresh = mutableSetOf<Pair<Int, Int>>()
    for (r in grid.indices) {
      for (c in grid[0].indices) {
        if (1 == grid[r][c]) { // fresh
          fresh.add(r to c)
        }
        if (2 == grid[r][c]) { // rotten
          rotten.offer(r to c)
        }
      }
    }

    var time = 0
    while (rotten.isNotEmpty()) {
      val size = rotten.size
      for (i in 0 until size) {
        val poll = rotten.poll()
        println("$poll - time $time")
        for (d in DIRECTION) {
          val next = poll.first + d[0] to poll.second + d[1]
          if (this.isValid(grid, next)) {
            grid[next.first][next.second] = 2
            rotten.offer(next)
            fresh.remove(next)
          }
        }
      }
      if (rotten.isNotEmpty()) {
        ++time
      }
    }

    return if (fresh.isEmpty()) time else -1
  }
}
