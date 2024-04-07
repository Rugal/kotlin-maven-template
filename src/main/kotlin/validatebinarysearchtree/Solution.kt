package validatebinarysearchtree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
class Solution {
  fun isValidBST(root: TreeNode?): Boolean = this.isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)

  private fun isValid(root: TreeNode?, left: Long, right: Long): Boolean {
    if (null == root) return true

    return if (root.`val` in left + 1 until right) this.isValid(root.left, left, root.`val`.toLong()) && this.isValid(root.right, root.`val`.toLong(), right) else false
  }
}
