package minimumdepthofbinarytree

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

class Solution {

  private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null

  fun minDepth(root: TreeNode?): Int {
    var result = 0
    if (null == root) return result
    val nodeQueue = LinkedList<TreeNode>()
    nodeQueue.offer(root)

    while (nodeQueue.isNotEmpty()) {
      result++
      val size = nodeQueue.size
      for (i in 0 until size) {
        val current = nodeQueue.poll()
        if (current.isLeaf()) {
          return result
        }
        current.left?.let {
          nodeQueue.offer(it)
        }

        current.right?.let {
          nodeQueue.offer(it)
        }
      }
    }

    return result
  }
}
