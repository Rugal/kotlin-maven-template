package searchsuggestionssystem

import java.util.LinkedList

class Solution {
  private fun search(trie: Trie, word: String): List<String> {
    val pq = mutableListOf<String>()

    var current: TrieNode = trie.root
    for (c in word) {
      val index = c - 'a'
      if (current.next[index] == null) return listOf()
      current = current.next[index]!!
    }

    val q = LinkedList<TrieNode>()
    q.offer(current)


    while (q.isNotEmpty()) {
      val node = q.poll()
      // add current word if exists
      node.word?.let(pq::add)

      node.next
        .filterNotNull()
        .forEach(q::offer)
    }

    return pq.sorted().toList().let {
      if (it.size > 3) it.subList(0, 3) else it
    }
  }

  fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
    // build
    val trie = Trie()
    for (p in products) {
      trie.insert(p)
    }
    // search
    return (1..searchWord.length).map { this.search(trie, searchWord.substring(0, it)) }
  }
}


private class Trie {

  val root = TrieNode()

  fun insert(word: String) {
    this.root.insert(word)
  }
}

private class TrieNode {
  var word: String? = null
  val next = Array<TrieNode?>(26) { null }

  fun insert(word: String) {
    var p = this

    for (c in word) {
      val index = c - 'a'
      if (p.next[index] == null) {
        p.next[index] = TrieNode()
      }
      p = p.next[index]!!
    }
    p.word = word
  }
}
