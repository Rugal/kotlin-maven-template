package binarytreemaximumpathsum

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">leetcode</a>
 */
class Solution {
  private var result = 0

  private fun dfs(root: TreeNode?): Int {
    if (null == root) return 0
    // at least 0, do not use
    val left = max(0, this.dfs(root.left))
    val right = max(0, this.dfs(root.right))
    // if we want to root at this node, we can then consider both subtree
    this.result = max(this.result, root.`val` + left + right)
    // otherwise, we can only choose one subtree go pass through current node
    return root.`val` + max(left, right)
  }

  /**
   * it can only be a path in the tree that form the result.<BR>
   * For any node it can be any of following situation.<BR>
   *
   * 1. not in result path
   * 2. in result path(subtree)
   *    a. as root node  : max result = root.val + left + right    :
   *    b. as other node : max result = root.val + max(left, right): this can contribute to result
   * 
   * traverse to get the max result
   */
  fun maxPathSum(root: TreeNode?): Int {
    this.result = Int.MIN_VALUE
    this.dfs(root)
    return this.result
  }
}
