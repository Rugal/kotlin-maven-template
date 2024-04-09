package sametree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/same-tree/
 */
class Solution {
  fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (null == p && null == q) return true
    return if (null != p && null != q)
      (p.`val` == q.`val`                     // same on current node
        && this.isSameTree(p.left, q.left)    // same on left tree
        && this.isSameTree(p.right, q.right)) // same on right tree
    else
      false
  }
}
