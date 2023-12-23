package invertbinarytree

import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun invertTree(root: TreeNode?): TreeNode? {
    if (null == root) return root

    val left = this.invertTree(root.right)
    val right = this.invertTree(root.left)
    root.left = left
    root.right = right
    return root
  }
}
