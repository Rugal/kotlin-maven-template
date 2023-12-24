package convertbsttogreatertree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
class Solution {
  private var sum = 0

  /**
   * Reverse in-order visit.
   */
  fun convertBST(root: TreeNode?): TreeNode? {
    if (null == root) return null
    // find the right most element first
    this.convertBST(root.right)
    // keep accumulating the sum and add it to remaining node
    sum += root.`val`
    root.`val` = sum
    this.convertBST(root.left)
    return root
  }
}
