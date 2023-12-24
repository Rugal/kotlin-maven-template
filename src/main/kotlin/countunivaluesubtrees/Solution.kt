package countunivaluesubtrees

import countgoodnodesinbinarytree.TreeNode

class Solution {

  private var result = 0

  private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null

  private fun dfs(root: TreeNode?): Pair<Int, Boolean> {
    if (null == root) return 0 to true
    
    val left = this.dfs(root.left)
    val right = this.dfs(root.right)
    // only if both subtree are univalue and they are equals to this node value as well
    val uniValue = left.second
      && right.second
      && (left.first == root.`val` || root.left == null)   // either equal or null
      && (right.first == root.`val` || root.right == null) // either equal or null

    if (uniValue) {
      this.result++
    }

    return root.`val` to uniValue
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
