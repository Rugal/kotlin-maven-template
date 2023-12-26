package kthsmallestelementinabst

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private var count = 0
  private var k = 0
  private var result = -1

  private fun dfs(root: TreeNode?) {
    if (null == root || this.result != -1) return

    if (this.result == -1) {
      this.dfs(root.left)
    }

    if (++this.count == k) {
      this.result = root.`val`
    }

    if (this.result == -1) {
      this.dfs(root.right)
    }
  }

  fun kthSmallest(root: TreeNode?, k: Int): Int {
    this.count = 0
    this.k = k
    this.result = -1

    this.dfs(root)

    return this.result
  }
}
