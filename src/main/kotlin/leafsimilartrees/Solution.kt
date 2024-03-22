package leafsimilartrees

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/leaf-similar-trees
 */
class Solution {

  private fun dfs(root: TreeNode?, l: MutableList<Int>) {
    if (null == root) return
    if (root.left == null && root.right == null) {
      l.add(root.`val`)
      return
    }
    this.dfs(root.left, l)
    this.dfs(root.right, l)
  }

  fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val l1 = mutableListOf<Int>()
    val l2 = mutableListOf<Int>()
    this.dfs(root1, l1)
    this.dfs(root2, l2)
    return l1 == l2
  }
}
