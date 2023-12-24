package countnodesequaltoaverageofsubtree

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private var result = 0

  /**
   * @return pair of int that is sum and count of subtree rooted at current node
   */
  private fun dfs(root: TreeNode?): Pair<Int, Int> {
    if (null == root) return 0 to 0

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)
    val sum = left.first + right.first + root.`val`
    val count = left.second + right.second + 1

    if (sum / count == root.`val`) {
      this.result++
    }

    return sum to count
  }

  fun averageOfSubtree(root: TreeNode?): Int {
    this.result = 0

    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }
}
