package binarytreepruning

import countgoodnodesinbinarytree.TreeNode

class Solution {

  private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null

  fun pruneTree(root: TreeNode?): TreeNode? {
    if (null == root) return null
    /*
      for any node, check left and right children before checking itself
      if it is leaf & 0, prune it
      else keep it
     */

    root.left = this.pruneTree(root.left)
    root.right = this.pruneTree(root.right)

    return if (root.isLeaf() && root.`val` == 0) null else root
  }
}
