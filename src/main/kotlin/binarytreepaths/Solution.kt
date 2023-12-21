package binarytreepaths

import countgoodnodesinbinarytree.TreeNode

class Solution {

  private val result = mutableListOf<String>()

  private fun dfs(root: TreeNode?, text: String) {
    if (null == root) {
      return
    }
    val value = if (text.isEmpty()) "${root.`val`}" else "$text->${root.`val`}"
    if (root.left == null && root.right == null) {
      this.result.add(value)
      return
    }

    this.dfs(root.left, value)
    this.dfs(root.right, value)
  }

  fun binaryTreePaths(root: TreeNode?): List<String> {
    this.result.clear()
    this.dfs(root, "")
    return this.result
  }
}
