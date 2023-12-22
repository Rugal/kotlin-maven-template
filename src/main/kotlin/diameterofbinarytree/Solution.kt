package diameterofbinarytree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

class Solution {

  private var result = 0

  private fun getDepth(root: TreeNode?): Int {
    if (null == root) return 0

    val left = this.getDepth(root.left)
    val right = this.getDepth(root.right)
    // update max result if optimal
    this.result = max(this.result, left + right)
    // otherwise return current node contribution
    return max(left, right) + 1
  }

  fun diameterOfBinaryTree(root: TreeNode?): Int {
    this.result = 0

    this.getDepth(root)

    return this.result
  }
}
