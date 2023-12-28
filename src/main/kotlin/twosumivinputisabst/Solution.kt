package twosumivinputisabst

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = mutableSetOf<Int>()
    var root = root
    val s = Stack<TreeNode>()

    while (null != root || s.isNotEmpty()) {
      while (null != root) {
        s.push(root)
        root = root.left
      }

      if (s.isNotEmpty()) {
        root = s.pop()
        // inorder visit
        if (set.contains(k - root.`val`)) return true
        set.add(root.`val`)
        // move right
        root = root.right
      }
    }

    return false
  }
}
