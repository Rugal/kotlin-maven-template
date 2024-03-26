package implementtrieprefixtree

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 */
class Trie {

  private val root = TrieNode()

  fun insert(word: String) {
    this.root.insert(word)
  }

  fun search(word: String): Boolean {
    var current = this.root
    for (c in word) {
      val index = c - 'a'
      if (current.next[index] == null) return false
      current = current.next[index]!!
    }

    return current.word != null // there must have exact word match
  }

  fun startsWith(prefix: String): Boolean {
    var current: TrieNode? = this.root
    for (c in prefix) {
      val index = c - 'a'
      if (current!!.next[index] == null) return false
      current = current.next[index]
    }

    return current != null // so long as there is node here
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
