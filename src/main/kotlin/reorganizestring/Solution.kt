package reorganizestring

import java.util.PriorityQueue

/**
 * https://leetcode.com/problems/reorganize-string/
 */
class Solution {
  fun reorganizeString(s: String): String {
    val m = mutableMapOf<Char, Int>()
    s.forEach { m[it] = m.getOrDefault(it, 0) + 1 }

    val queue = PriorityQueue<Pair<Char, Int>> { a, b -> b.second - a.second }
    queue.addAll(m.entries.map { it.key to it.value })

    val sb = StringBuilder()

    while (queue.isNotEmpty()) {
      val first = queue.poll()
      sb.append(first.first)

      // case: aa
      if (queue.isEmpty()) return if (first.second >= 2) "" else sb.toString() // case: aba

      val second = queue.poll()
      sb.append(second.first)

      // for next round
      if (first.second > 1) queue.offer(first.first to first.second - 1)
      if (second.second > 1) queue.offer(second.first to second.second - 1)
    }

    // case: abab
    return sb.toString()
  }
}
