package pathsumii

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private val result = mutableListOf<List<Int>>()
  private var target = 0

  private fun dfs(root: TreeNode?, current: Int, list: MutableList<Int>) {
    if (null == root) return

    list.add(root.`val`)
    val next = current + root.`val`

    if (root.left == null && root.right == null && next == this.target) {
      this.result.add(list.toList())
    } else {
      this.dfs(root.left, next, list)
      this.dfs(root.right, next, list)
    }
    list.removeLast()
  }

  fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    this.target = targetSum
    this.result.clear()
    this.dfs(root, 0, mutableListOf())
    return this.result
  }
}
