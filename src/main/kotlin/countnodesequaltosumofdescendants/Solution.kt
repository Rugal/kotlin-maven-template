package countnodesequaltosumofdescendants

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants/
 */
class Solution {
  private var result = 0

  private fun dfs(root: TreeNode?): Int {
    if (null == root) return 0

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)

    if (left + right == root.`val`) {
      this.result++
    }

    return left + right + root.`val`
  }

  fun equalToDescendants(root: TreeNode?): Int {
    this.result = 0
    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }
}
