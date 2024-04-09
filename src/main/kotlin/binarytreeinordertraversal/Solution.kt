package binarytreeinordertraversal

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
class Solution {
  fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    if (null == root) return result

    val s = Stack<TreeNode>()
    var root = root

    // iterative way of DFS
    while (null != root || s.isNotEmpty()) {
      while (null != root) {
        s.push(root)
        root = root.left
      }

      if (s.isNotEmpty()) {
        val node = s.pop()
        result.add(node.`val`)
        root = node.right
      }
    }

    return result
  }
}
