package binarysearchtreeiterator

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
class BSTIterator(root: TreeNode?) {

  private val s = Stack<TreeNode>()

  init {
    this.moveLeft(root)
  }

  /**
   * iterative way to in-order traverse.  
   */
  private fun moveLeft(root: TreeNode?) {
    var current: TreeNode? = root
    while (null != current) {
      s.push(current)
      current = current.left
    }
  }

  fun next(): Int {
    val node = this.s.pop()

    this.moveLeft(node.right)

    return node.`val`
  }

  fun hasNext(): Boolean = this.s.isNotEmpty()
}
