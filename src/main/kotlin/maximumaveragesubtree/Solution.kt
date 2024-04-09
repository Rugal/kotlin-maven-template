package maximumaveragesubtree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/maximum-average-subtree/description/
 */
@Suppress("DuplicatedCode")
class Solution {

  private var result = 0.0

  /**
   * @return pair of sum and node count
   */
  private fun dfs(root: TreeNode?): Pair<Int, Int> {
    if (null == root) return 0 to 0

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)

    val sum = left.first + right.first + root.`val`
    val count = left.second + right.second + 1

    this.result = max(this.result, 1.0 * sum / count)

    return sum to count
  }

  fun maximumAverageSubtree(root: TreeNode?): Double {
    this.result = 0.0
    if (null == root) return result

    this.dfs(root)

    return this.result
  }
}
