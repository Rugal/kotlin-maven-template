package deletenodeinabst

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private fun findSuccessor(root: TreeNode): TreeNode {
    var r = root
    while (r.left != null) {
      r = r.left!!
    }
    return r
  }

  fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (null == root) return null

    if (key != root.`val`) {
      if (key < root.`val`) {
        root.left = this.deleteNode(root.left, key)
      } else {
        root.right = this.deleteNode(root.right, key)
      }
      return root
    }
    // now we found target
    // just discard this node
    if (root.left == null && root.right == null) return null
    if (root.left != null && root.right != null) {
      // has 2 children
      val successor = this.findSuccessor(root.right!!)
      root.`val` = successor.`val`
      root.right = this.deleteNode(root.right, successor.`val`)
      return root
    }
    // has either left or right child
    return if (root.left != null) root.left else root.right
  }
}
