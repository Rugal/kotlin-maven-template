package minimumdepthofbinarytree

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
class Solution {

  private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null

  fun minDepth(root: TreeNode?): Int {
    if (null == root) return 0
    var result = 0
    val nodeQueue = LinkedList<TreeNode>()
    nodeQueue.offer(root)

    while (nodeQueue.isNotEmpty()) {
      result++
      val size = nodeQueue.size
      for (i in 0 until size) {
        nodeQueue.poll().also {
          if (it.isLeaf()) return result // return as soon as reaching leaf
          it.left?.let(nodeQueue::offer)
          it.right?.let(nodeQueue::offer)
        }
      }
    }

    return result
  }
}
