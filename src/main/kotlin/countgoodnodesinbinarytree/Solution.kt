package countgoodnodesinbinarytree

import kotlin.math.max

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
  private var good = 0

  fun goodNodes(root: TreeNode?): Int {
    this.good = 0

    root?.also {
      this.traverse(it, Int.MIN_VALUE)
    }

    return this.good
  }

  private fun traverse(root: TreeNode, max: Int) {
    if (root.`val` >= max) {
      this.good++
    }
    root.left?.also {
      this.traverse(it, max(max, root.`val`))
    }
    root.right?.also {
      this.traverse(it, max(max, root.`val`))
    }
  }
}


class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}
