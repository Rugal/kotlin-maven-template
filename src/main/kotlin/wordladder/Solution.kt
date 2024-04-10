package wordladder

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/word-ladder/
 */
class Solution {

  private fun build(wordList: List<String>): Map<String, List<String>> =
    mutableMapOf<String, MutableList<String>>().also { m ->
      wordList.forEach {
        for (i in it.indices)
          m.computeIfAbsent("${it.substring(0, i)}_${it.substring(i + 1)}") { mutableListOf() }.add(it)
      }
    }

  fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    wordList.toSet().also { if (endWord !in it) return 0 }

    val build = this.build(wordList)
    val visited = mutableSetOf<String>()
    val queue: Queue<String> = LinkedList()

    queue.offer(beginWord)

    var level = 1
    while (queue.isNotEmpty()) {
      val size = queue.size
      for (i in 0 until size) {
        val p = queue.poll()
        if (p == endWord) return level
        // start next round
        visited.add(p)

        for (c in p.indices) {
          val key = "${p.substring(0, c)}_${p.substring(c + 1)}"
          build.getOrDefault(key, listOf())
            .filterNot(visited::contains)
            .forEach(queue::offer)
        }
      }
      ++level
    }
    return 0
  }
}
