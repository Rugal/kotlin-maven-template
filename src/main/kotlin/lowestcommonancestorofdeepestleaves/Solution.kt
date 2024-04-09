package lowestcommonancestorofdeepestleaves

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
class Solution {

  private var result: TreeNode? = null
  private var maxDepth = 0

  private fun dfs(root: TreeNode?, depth: Int): Int {
    if (null == root) return depth

    val left = this.dfs(root.left, depth + 1)
    val right = this.dfs(root.right, depth + 1)
    // whichever is deeper
    return max(left, right).also {
      // update max depth if any
      this.maxDepth = max(it, this.maxDepth) // max depth getting deeper by recursion

      // both side contains max depth, means current node is the LCA
      if (this.maxDepth == left && this.maxDepth == right) { // last node that has max depth on both side
        // current node is the new result, update result
        this.result = root
      }
    }
  }
  
  fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    this.result = null
    this.maxDepth = 0

    this.dfs(root, 0)

    return this.result
  }
}
