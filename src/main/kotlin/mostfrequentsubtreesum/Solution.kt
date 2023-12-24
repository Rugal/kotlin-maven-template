package mostfrequentsubtreesum

import countgoodnodesinbinarytree.TreeNode

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

    val sum = left + right + root.`val`
    // initialize if not found before
    this.map.putIfAbsent(sum, 0)
    // increment by one
    this.map[sum] = this.map[sum]!! + 1
    // update highest
    if (this.map[sum]!! > this.highest) {
      this.highest = this.map[sum]!!
    }

    return sum
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
