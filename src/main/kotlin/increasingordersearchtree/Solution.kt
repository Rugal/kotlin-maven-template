package increasingordersearchtree

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

class Solution {

  private val s = Stack<TreeNode>()

  private fun dfs(root: TreeNode?) {
    if (null == root) return

    // reverse in-order visit
    this.dfs(root.right)
    this.s.push(root)
    this.dfs(root.left)
  }

  fun increasingBST(root: TreeNode?): TreeNode? {
    if (null == root) return null

    this.s.clear()
    this.dfs(root)

    return this.s.pop().also {
      var current = it
      while (this.s.isNotEmpty()) {
        current.right = this.s.pop()
        current = current.right
        current.left = null
        current.right = null
      }
    }
  }
}
