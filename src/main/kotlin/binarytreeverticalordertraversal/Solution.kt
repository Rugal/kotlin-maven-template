package binarytreeverticalordertraversal

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

class Solution {

  private val map = mutableMapOf<Int, MutableList<Int>>()
  
  fun verticalOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (null == root) return result

    val nodeQueue = LinkedList<TreeNode>()
    val indexQueue = LinkedList<Int>()
    nodeQueue.offer(root)
    indexQueue.offer(0)

    while (nodeQueue.isNotEmpty()) {
      val node = nodeQueue.poll()
      val index = indexQueue.poll()
      // add value to right column
      map.putIfAbsent(index, mutableListOf())
      map[index]!!.add(node.`val`) // append from left to right
      // process left
      node.left?.also {
        nodeQueue.offer(it)
        indexQueue.offer(index - 1) // move left column
      }
      // process right
      node.right?.also {
        nodeQueue.offer(it)
        indexQueue.offer(index + 1) // move right column
      }
    }

    return this.map.keys
      .toList()
      .sorted()
      .map { this.map[it]!! }
  }
}
