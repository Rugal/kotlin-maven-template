package convertbinarysearchtreetosorteddoublylinkedlist

import java.util.Stack

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
class Solution {
  private val s = Stack<Node>()

  private fun dfs(root: Node?) {
    if (null == root) return

    this.dfs(root.right)
    this.s.push(root)
    this.dfs(root.left)
  }

  fun treeToDoublyList(root: Node?): Node? {
    if (null == root) return null

    this.dfs(root)

    val root = this.s.pop()

    var current = root
    while (s.isNotEmpty()) {
      val pop = this.s.pop()

      current.right = pop
      pop.left = current

      current = current.right
    }

    current.right = root
    root.left = current

    return root
  }
}

data class Node(
  var `val`: Int,
  var left: Node? = null,
  var right: Node? = null,
) 
