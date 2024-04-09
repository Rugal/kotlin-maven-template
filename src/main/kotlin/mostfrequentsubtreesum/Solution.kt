package mostfrequentsubtreesum

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum
 */
class Solution {
  private val map = mutableMapOf<Int, Int>()
  private var highest = 0

  /**
   * @return the sum of this subtree rooted at this node
   */
  private fun dfs(root: TreeNode?): Int {
    if (null == root) return 0
    val left = this.dfs(root.left)
    val right = this.dfs(root.right)

    return (left + right + root.`val`).also {
      // initialize if not found before
      this.map[it] = this.map.getOrDefault(it, 0) + 1
      // update highest
      this.highest = max(this.highest, this.map[it]!!)
    }
  }

  fun findFrequentTreeSum(root: TreeNode?): IntArray {
    if (null == root) return intArrayOf()

    this.dfs(root)

    return this.map
      .filter { it.value == this.highest }
      .map { it.key }
      .toIntArray()
  }
}
