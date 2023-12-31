package largestbstsubtree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/largest-bst-subtree/
 */
class Solution {
  private var result = 0

  private fun dfs(root: TreeNode?): Triple<Int, Int, Int> {
    if (null == root) return Triple(0, 0, 0)

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)

    if (-1 == left.first                               // left subtree already invalid
      || null != root.left && left.third >= root.`val` // or has left tree but current value is even LE left subtree's right bound
    ) return Triple(-1, 0, 0)
    if (-1 == right.first                              // right subtree already invalid
      || null != root.right && root.`val` >= right.second // or has right tree but current value is even GE right subtree's left bound
    ) return Triple(-1, 0, 0)

    return (left.first + right.first + 1).let {
      this.result = max(this.result, it) // update max result
      Triple(
        it,
        if (null == root.left) root.`val` else left.second,  // only bound only if has subtree
        if (null == root.right) root.`val` else right.third  // only bound only if has subtree
      )
    }
  }

  fun largestBSTSubtree(root: TreeNode?): Int {
    this.dfs(root)
    return this.result
  }
}
