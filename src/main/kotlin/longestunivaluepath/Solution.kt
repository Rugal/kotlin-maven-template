package longestunivaluepath

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

class Solution {
  private var result = 0

  private fun dfs(root: TreeNode?): Int {
    if (null == root) return 0

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)
    var leftCount = 0
    var rightCount = 0
    // only if left subtree forms uniValue path, so add one more for root
    if (null != root.left && root.`val` == root.left!!.`val`) {
      leftCount = left + 1
    }
    // only if right subtree forms uniValue path, so add one more for root
    if (null != root.right && root.`val` == root.right!!.`val`) {
      rightCount = right + 1
    }
    // in case of uniValue path formed at root subtree
    this.result = max(this.result, leftCount + rightCount)
    // but must return only one path, otherwise would form graph
    return max(leftCount, rightCount)
  }

  fun longestUnivaluePath(root: TreeNode?): Int {
    this.result = 0
    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }
}
