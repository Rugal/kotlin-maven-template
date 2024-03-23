package nearestexitfromentranceinmaze

import java.util.LinkedList
import java.util.Queue

private val DIRECTION = arrayOf(
  intArrayOf(1, 0),
  intArrayOf(-1, 0),
  intArrayOf(0, 1),
  intArrayOf(0, -1),
)

/**
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze
 */
class Solution {

  private fun isValid(maze: Array<CharArray>, poll: Pair<Int, Int>): Boolean =
    poll.first in maze.indices
      && poll.second in maze[0].indices
      && maze[poll.first][poll.second] == '.'

  private fun isExit(maze: Array<CharArray>, poll: Pair<Int, Int>): Boolean =
    (poll.first == 0
      || poll.first == maze.size - 1
      || poll.second == 0
      || poll.second == maze[0].size - 1)
      && maze[poll.first][poll.second] == '.'

  fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.offer(entrance[0] to entrance[1])
    var step = 0

    while (q.isNotEmpty()) {
      val size = q.size
      for (i in 0 until size) {
        val poll = q.poll()
        maze[poll.first][poll.second] = '+'

        for (d in DIRECTION) {
          val next = poll.first + d[0] to poll.second + d[1]
          if (!this.isValid(maze, next)) continue
          // if this is the exit
          if (this.isExit(maze, next)) return step
          q.offer(next)
        }
      }
      ++step
    }

    return -1
  }
}
