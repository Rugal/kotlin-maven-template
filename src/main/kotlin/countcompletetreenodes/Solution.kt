package countcompletetreenodes

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
class Solution {

  /**
   * The tree is guaranteed to be complete.
   */
  fun countNodes(r: TreeNode?): Int = if (null != r) 1 + this.countNodes(r.left) + this.countNodes(r.right) else 0
}
