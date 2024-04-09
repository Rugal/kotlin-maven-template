package binarytreerightsideview

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
class Solution {
  private val result = mutableListOf<Int>()
  private var maxLevel = -1

  private fun dfs(root: TreeNode?, level: Int) {
    if (null == root) return

    // the very first visit of a new level must be the rightmost node to be seen from right side view
    if (this.maxLevel < level) {
      this.maxLevel = level
      this.result.add(root.`val`)
    }
    // traverse right first
    this.dfs(root.right, level + 1)
    this.dfs(root.left, level + 1)
  }

  fun rightSideView(root: TreeNode?): List<Int> {
    this.result.clear()
    if (null == root) return this.result

    this.dfs(root, 0)

    return this.result
  }
}
