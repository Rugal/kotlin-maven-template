package longestzigzagpathinabinarytree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
 */
class Solution {
  private var length = 0

  /**
   * @param left going left in this invocation
   */
  private fun dfs(root: TreeNode?, left: Boolean, step: Int) {
    if (null == root) return
    this.length = max(this.length, step)

    // if going left
    if (left) {
      // just go, but next level should go right
      this.dfs(root.left, false, step + 1)
      // cannot go left, so next level should go left, and reset to step 1
      this.dfs(root.right, true, 1)
    } else { // if going right
      // just go, but next level should go left
      this.dfs(root.right, true, step + 1)
      // cannot go right, so next level should go right, and reset to step 1
      this.dfs(root.left, false, 1)
    }
  }


  fun longestZigZag(root: TreeNode?): Int {
    this.length = 0

    this.dfs(root, true, 0)
    this.dfs(root, false, 0)

    return this.length
  }
}
