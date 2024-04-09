package binarytreeverticalordertraversal

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal
 */
class Solution {

  fun verticalOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (null == root) return result

    /**
     * key is column, value is the list of nodes
     */
    val map = mutableMapOf<Int, MutableList<Int>>()

    LinkedList<Pair<TreeNode, Int>>().also { q ->
      q.offer(root to 0)

      while (q.isNotEmpty()) {
        val poll = q.poll()
        // add value to right column
        map.computeIfAbsent(poll.second) { mutableListOf() }.add(poll.first.`val`)
        // append from left to right
        poll.first.left?.also { // move left column
          q.offer(it to poll.second - 1)
        }
        poll.first.right?.also { // move right column
          q.offer(it to poll.second + 1)
        }
      }
    }
    
    return map.keys
      .toList()
      .sorted()
      .map { map[it]!! }
  }
}
