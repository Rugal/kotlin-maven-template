package twosumbsts

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    var root1 = root1
    var root2 = root2
    val s1 = Stack<TreeNode>()
    val s2 = Stack<TreeNode>()

    while (null != root1 || null != root2
      || s1.isNotEmpty() || s2.isNotEmpty()
    ) {
      // regular inorder traversal
      while (null != root1) {
        s1.push(root1)
        root1 = root1.left
      }
      // reverse inorder traversal
      while (null != root2) {
        s2.push(root2)
        root2 = root2.right
      }

      if (s1.isEmpty() || s2.isEmpty()) {
        // no more value from either tree
        return false
      }
      val value = s1.peek().`val` + s2.peek().`val`
      if (value == target) return true

      if (value < target) {
        // too small, move left pointer to right
        root1 = s1.pop()
        root1 = root1.right
      } else {
        // too big, move right pointer to left
        root2 = s2.pop()
        root2 = root2.left
      }
    }

    return false
  }
}
