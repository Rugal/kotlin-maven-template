package findmodeinbinarysearchtree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
class Solution {

  private var currentValue = Int.MAX_VALUE
  private var currentCount = 0
  private var finalCount = Int.MIN_VALUE
  private val result = mutableListOf<Int>()

  private fun findFrequency(root: TreeNode?) {
    if (null == root) return

    this.findFrequency(root.left)

    if (root.`val` != this.currentValue) {
      this.currentValue = root.`val`
      this.currentCount = 0
    }
    this.currentCount++
    this.finalCount = max(this.finalCount, this.currentCount)

    this.findFrequency(root.right)
  }

  private fun getMode(root: TreeNode?) {
    if (null == root) return

    this.getMode(root.left)

    if (root.`val` != this.currentValue) {
      this.currentValue = root.`val`
      this.currentCount = 0
    }
    this.currentCount++
    if (this.finalCount == this.currentCount) {
      this.result.add(root.`val`)
    }

    this.getMode(root.right)
  }

  fun findMode(root: TreeNode?): IntArray {
    this.findFrequency(root)
    this.currentValue = Int.MAX_VALUE
    this.getMode(root)
    return this.result.toIntArray()
  }
}
