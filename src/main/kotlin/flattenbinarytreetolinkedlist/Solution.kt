package flattenbinarytreetolinkedlist

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class Solution {
  private val queue = LinkedList<TreeNode>()

  private fun dfs(root: TreeNode?) {
    if (null == root) return

    queue.offer(root) // pre-order visitation
    this.dfs(root.left)
    this.dfs(root.right)
  }

  fun flatten(root: TreeNode?) {
    if (null == root) return
    this.dfs(root)
    var current: TreeNode = root
    this.queue.pop()
    while (this.queue.isNotEmpty()) {
      current.left = null
      current.right = this.queue.pop()
      current = current.right!!
    }
  }
}
