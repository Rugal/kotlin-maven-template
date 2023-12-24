package maximumdepthofnarytree

import kotlin.math.max

class Solution {
  private var result = 0

  private fun dfs(root: Node?, level: Int) {
    if (null == root) return
    this.result = max(this.result, level)

    root.children.forEach { this.dfs(it, level + 1) }
  }

  fun maxDepth(root: Node?): Int {
    this.result = 0
    if (null == root) return this.result

    this.dfs(root, 1)

    return this.result
  }
}

data class Node(var `val`: Int, var children: List<Node> = listOf())
