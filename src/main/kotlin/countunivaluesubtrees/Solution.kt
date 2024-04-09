package countunivaluesubtrees

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/count-univalue-subtrees
 */
class Solution {

  private var result = 0

  /**
   * @return if current node forms uniValue
   */
  private fun dfs(root: TreeNode?): Boolean {
    if (null == root) return true

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)
    // only if both subtree are uniValue, and they are equals to this node value as well
    val uniValue = left && right
      && (root.left == null || root.left!!.`val` == root.`val`)   // either equal or null
      && (root.right == null || root.right!!.`val` == root.`val`) // either equal or null

    if (uniValue) {
      this.result++
    }

    return uniValue
  }

  /**
   * @param root: the given tree
   * @return: the number of uni-value subtrees.
   */
  fun countUnivalSubtrees(root: TreeNode?): Int {
    this.result = 0
    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }
}
