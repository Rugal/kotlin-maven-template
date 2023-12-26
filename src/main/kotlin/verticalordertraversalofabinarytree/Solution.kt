package verticalordertraversalofabinarytree

import java.util.LinkedList
import java.util.PriorityQueue
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
class Solution {
  fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    if (null == root) return listOf()

    val cache = mutableMapOf<Int, PriorityQueue<Node>>()
    val nodeQueue = LinkedList<Node>()
    nodeQueue.offer(Node(root, 0, 0))

    // must be on the same column already, sort by row if not on the same row, otherwise sort by value nature order
    val c = Comparator<Node> { a, b -> if (a.row == b.row) a.root.`val` - b.root.`val` else a.row - b.row }

    while (nodeQueue.isNotEmpty()) {
      val node = nodeQueue.poll()

      cache.putIfAbsent(node.column, PriorityQueue(c))
      cache[node.column]!!.offer(node)

      node.root.left?.also { nodeQueue.offer(Node(it, node.row + 1, node.column - 1)) }
      node.root.right?.also { nodeQueue.offer(Node(it, node.row + 1, node.column + 1)) }
    }

    return cache.keys
      .toList()
      .sorted()
      .map { cache[it]!!.sortedWith(c).map { it.root.`val` } }
  }
}

data class Node(
  val root: TreeNode,
  val row: Int,
  val column: Int
)
