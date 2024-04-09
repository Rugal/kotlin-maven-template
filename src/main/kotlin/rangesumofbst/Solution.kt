package rangesumofbst

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
class Solution {
  fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (null == root) return 0

    return (if (root.`val` in low..high) root.`val` else 0) +
      this.rangeSumBST(root.left, low, high) +
      this.rangeSumBST(root.right, low, high)
  }
}
