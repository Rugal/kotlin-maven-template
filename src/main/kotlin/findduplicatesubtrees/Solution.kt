package findduplicatesubtrees

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
class Solution {
  private val visited = mutableMapOf<String, Int>()
  private val result = mutableListOf<TreeNode>()

  private fun dfs(root: TreeNode?): String {
    if (null == root) return "N"
    // record every single subtree with the following format
    return "${root.`val`},${dfs(root.left)},${dfs(root.right)}".also {
      // it can be more than 2 times of duplication
      visited[it] = visited.getOrDefault(it, 0) + 1
      // only add once for each duplication
      if (visited[it] == 2) result.add(root)
    }
  }

  fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode> {
    this.visited.clear()
    this.result.clear()

    this.dfs(root)

    return this.result
  }
}
