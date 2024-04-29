package wordladderii

import java.util.LinkedList
import java.util.Queue

/**
 * https://leetcode.com/problems/word-ladder-ii/
 */
class Solution {

  private fun space(it: String, i: Int): String = "${it.substring(0, i)}_${it.substring(i + 1)}"

  private fun build(wordList: List<String>): Map<String, List<String>> =
    mutableMapOf<String, MutableList<String>>().also { m ->
      wordList.forEach {
        for (i in it.indices) m.computeIfAbsent(space(it, i)) { mutableListOf() }.add(it)
      }
    }

  fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
    wordList.toSet().also { if (endWord !in it) return listOf() }

    val result = mutableListOf<List<String>>()

    val map = this.build(wordList)
    val visited = mutableSetOf<String>()
    val currentVisited = mutableSetOf<String>()
    val queue: Queue<MutableList<String>> = LinkedList()

    queue.offer(mutableListOf(beginWord))
    visited.add(beginWord)

    var found = false

    while (!found && queue.isNotEmpty()) {
      visited.addAll(currentVisited)
      // allow repeat visit within current level
      currentVisited.clear()

      val size = queue.size
      for (i in 0 until size) {
        val poll = queue.poll()
        if (poll.last() == endWord) { // finally matched
          result += poll
          found = true // no need to go any further, but need to finish the current level
          continue
        }

        val word: String = poll.last()
        word.indices.forEach { index ->
          map
            .getOrDefault(space(word, index), listOf())
            .filterNot(visited::contains)
            .forEach { last ->
              currentVisited.add(last)
              queue.offer(ArrayList(poll + last))
            }
        }
      }
    }

    return result
  }
}
