package convertbsttogreatertree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
class Solution {
  private var sum = 0

  /**
   * Reverse in-order visit.
   *
   * Accumulating the value by reverse in-order visit, and add to each left node
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

class Solution1 {
  private var sum = 0
  
  fun convertBST(root: TreeNode?): TreeNode? {
    if (root == null) return null
    
    this.convertBST(root.right)
    
    // visit
    this.sum += root.`val`
    root.`val` = sum

    this.convertBST(root.left)
    return root
  }
}
