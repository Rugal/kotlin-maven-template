package pathsum

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private var target: Int = 0
  private var result = false

  private fun dfs(root: TreeNode?, current: Int) {
    // early exit if already found
    if (null == root || this.result) {
      return
    }
    val next = current + root.`val`
    if (root.left == null && root.right == null && next == this.target) {
      this.result = true
      return
    }

    this.dfs(root.left, next)
    this.dfs(root.right, next)
  }

  fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    this.target = targetSum
    this.result = false
    this.dfs(root, 0)
    return this.result
  }
}
