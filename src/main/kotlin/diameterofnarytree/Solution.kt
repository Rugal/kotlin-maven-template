package diameterofnarytree

import kotlin.math.max

data class UndirectedGraphNode(
  var label: Int = 0,
  var neighbors: MutableList<UndirectedGraphNode> = mutableListOf()
)

/**
 * https://leetcode.com/problems/diameter-of-n-ary-tree
 */
class Solution {
  private var result = 0

  private fun getDepth1(node: UndirectedGraphNode?): Int {
    if (null == node) return 0

    return node.neighbors
      .map { this.getDepth1(it) }
      .toMutableList()
      .also {
        it.add(0)
        it.add(0)
      }
      .sortedDescending()
      .take(2).let {
        this.result = max(this.result, it[0] + it[1])
        it[0] + 1
      }
  }

  private fun getDepth(node: UndirectedGraphNode?): Int {
    if (null == node || node.neighbors.isEmpty()) return 0

    // select the top two largest heights
    var max = 0
    var next = 0
    for (child in node.neighbors) {
      val height = getDepth(child) + 1

      // find first 2 big number
      if (height > max) {
        next = max
        max = height
      } else if (height > next) {
        next = height
      }
      result = max(result, max + next)
    }
    return max
  }

  /**
   * @param root: the root of the tree
   * @return: Maximum diameter of the N-ary Tree
   */
  fun diameter(root: UndirectedGraphNode?): Int {
    this.result = 0
    this.getDepth1(root)
    return this.result
  }
}
