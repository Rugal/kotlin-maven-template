package maximumbinarytree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
class Solution {
  private var nums = intArrayOf()

  /**
   * @return pair of index and the max value
   */
  private fun getMaxIndex(begin: Int, end: Int): Pair<Int, Int> {
    var max = -1
    var index = -1
    for (i in begin..end) {
      if (this.nums[i] > max) {
        max = this.nums[i]
        index = i
      }
    }
    return index to max
  }

  private fun dfs(begin: Int, end: Int): TreeNode? {
    if (begin > end) return null
    val p = this.getMaxIndex(begin, end)

    return TreeNode(p.second).also {
      it.left = this.dfs(begin, p.first - 1)
      it.right = this.dfs(p.first + 1, end)
    }
  }

  fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    this.nums = nums
    return this.dfs(0, nums.size - 1)
  }
}
