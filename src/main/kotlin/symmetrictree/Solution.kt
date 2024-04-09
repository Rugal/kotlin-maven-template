package symmetrictree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
class Solution {

  private fun dfs(left: TreeNode?, right: TreeNode?): Boolean {
    if (null == left && null == right) return true
    if (null == left || null == right) return false

    return left.`val` == right.`val`
      && this.dfs(left.left, right.right)
      && this.dfs(left.right, right.left)
  }

  fun isSymmetric(root: TreeNode?): Boolean = if (null == root) true else this.dfs(root.left, root.right)
}
