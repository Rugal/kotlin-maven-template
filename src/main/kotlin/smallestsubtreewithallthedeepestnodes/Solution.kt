package smallestsubtreewithallthedeepestnodes

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

class Solution {

  private var result: TreeNode? = null
  private var maxDepth = 0

  private fun dfs(root: TreeNode?, depth: Int): Int {
    if (null == root) return depth

    val left = this.dfs(root.left, depth + 1)
    val right = this.dfs(root.right, depth + 1)
    // whichever is deeper
    val currentDepth = max(left, right)
    // update max depth if any
    this.maxDepth = max(currentDepth, this.maxDepth)

    // both side contains max depth, means current node is the LCA
    if (this.maxDepth == left && this.maxDepth == right) {
      // current node is the new result, update result
      this.result = root
    }

    return currentDepth
  }

  fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
    this.result = null
    this.maxDepth = 0

    this.dfs(root, 0)

    return this.result
  }
}
