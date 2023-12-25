package mergetwobinarytrees

import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if (null == root1 && null == root2) return null
    
    return TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0)).also {
      it.left = this.mergeTrees(root1?.left, root2?.left)
      it.right = this.mergeTrees(root1?.right, root2?.right)
    }
  }
}
