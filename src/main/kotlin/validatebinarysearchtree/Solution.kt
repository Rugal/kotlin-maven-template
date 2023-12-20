package validatebinarysearchtree

import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun isValidBST(root: TreeNode?): Boolean {
    return this.isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
  }

  private fun isValid(root: TreeNode?, left: Long, right: Long): Boolean {
    if (null == root) {
      return true
    }

    if (root.`val` in (left + 1)..<right) {
      return this.isValid(root.left, left, root.`val`.toLong()) && this.isValid(root.right, root.`val`.toLong(), right)
    }

    return false
  }
}
