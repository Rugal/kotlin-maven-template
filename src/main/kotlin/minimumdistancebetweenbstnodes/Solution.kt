package minimumdistancebetweenbstnodes

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.min
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
class Solution {
  private val queue = LinkedList<Int>()
  private var result = Int.MAX_VALUE

  private fun dfs(root: TreeNode?) {
    if (null == root) return

    this.dfs(root.left)

    this.queue.offer(root.`val`)
    if (this.queue.size > 2) this.queue.pop()
    if (this.queue.size == 2) {
      this.result = min(this.result, abs(this.queue.first() - this.queue.last()))
    }

    this.dfs(root.right)
  }

  fun minDiffInBST(root: TreeNode?): Int {
    this.result = Int.MAX_VALUE

    this.dfs(root)

    return this.result
  }
}
