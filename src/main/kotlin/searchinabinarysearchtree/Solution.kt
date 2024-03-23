package searchinabinarysearchtree

import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun searchBST(root: TreeNode, target: Int): TreeNode? {
    var current: TreeNode? = root

    while (current != null) {
      if (current.`val` == target) return current

      current = (if (target < current.`val`) current.left else current.right)
    }

    return null
  }
}
