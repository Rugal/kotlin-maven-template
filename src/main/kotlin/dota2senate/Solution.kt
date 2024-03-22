package dota2senate

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/dota2-senate
 */
class Solution {
  fun predictPartyVictory(senate: String): String {
    val R: Queue<Int> = LinkedList()
    val D: Queue<Int> = LinkedList()
    for ((index, c) in senate.withIndex()) {
      if (c == 'R') {
        R.offer(index)
      } else {
        D.offer(index)
      }
    }

    while (R.isNotEmpty() && D.isNotEmpty()) {
      if (R.peek() < D.peek()) {
        D.poll()
        R.offer(R.poll() + senate.length)
      } else {
        R.poll()
        D.offer(D.poll() + senate.length)
      }
    }

    return if (R.isNotEmpty()) "Radiant" else "Dire"
  }
}
