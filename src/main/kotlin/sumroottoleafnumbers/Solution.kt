package sumroottoleafnumbers

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
class Solution {

  private var result = 0

  private fun dfs(root: TreeNode?, current: Int) {
    if (null == root) {
      return
    }
    val next = current * 10 + root.`val`
    // if leaf
    if (root.left == null && root.right == null) {
      result += next
      return
    }

    this.dfs(root.left, next)
    this.dfs(root.right, next)
  }

  fun sumNumbers(root: TreeNode?): Int {
    this.result = 0
    this.dfs(root, 0)
    return this.result
  }
}
