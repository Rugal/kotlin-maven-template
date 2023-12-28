package subtreeofanothertree

import countgoodnodesinbinarytree.TreeNode

class Solution {

  private fun isSameTree(a: TreeNode?, b: TreeNode?): Boolean {
    if (null == a && null == b) return true
    if (null == a || null == b) return false
    return a.`val` == b.`val`
      && this.isSameTree(a.left, b.left)
      && this.isSameTree(a.right, b.right)
  }

  fun isSubtree(root: TreeNode?, subRoot: TreeNode): Boolean {
    if (null == root) return false

    if (root.`val` == subRoot.`val` && this.isSameTree(root, subRoot)) {
      return true
    }

    return this.isSubtree(root.left, subRoot)
      || this.isSubtree(root.right, subRoot)
  }
}
