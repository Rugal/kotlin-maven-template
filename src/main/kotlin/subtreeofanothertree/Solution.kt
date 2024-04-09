package subtreeofanothertree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/subtree-of-another-tree
 */
class Solution {

  private fun isSameTree(a: TreeNode?, b: TreeNode?): Boolean {
    if (null == a && null == b) return true  // all tree node matched
    if (null == a || null == b) return false // some node not matched
    return a.`val` == b.`val`
      && this.isSameTree(a.left, b.left)
      && this.isSameTree(a.right, b.right)
  }

  fun isSubtree(root: TreeNode?, subRoot: TreeNode): Boolean {
    if (null == root) return false

    // if the root matched, start matching
    if (root.`val` == subRoot.`val` && this.isSameTree(root, subRoot)) {
      return true
    }

    // try matching left or right
    return this.isSubtree(root.left, subRoot)
      || this.isSubtree(root.right, subRoot)
  }
}
