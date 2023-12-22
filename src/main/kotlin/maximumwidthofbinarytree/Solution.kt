package maximumwidthofbinarytree

import java.util.LinkedList
import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

class Solution {

  fun widthOfBinaryTree(root: TreeNode?): Int {
    if (null == root) return 0

    var result = 0

    val nodeQueue = LinkedList<TreeNode>()
    val indexQueue = LinkedList<Int>()

    nodeQueue.offer(root)
    indexQueue.offer(1)

    while (nodeQueue.isNotEmpty()) {
      val size = nodeQueue.size
      var begin = 0
      var end = 0
      // for each level
      for (i in 0 until size) {
        val node = nodeQueue.poll()
        val index = indexQueue.poll()
        // left most node of this level
        if (0 == i) {
          begin = index
        }
        // right most node of this level
        if (size - 1 == i) {
          end = index
        }
        // add left child
        if (null != node.left) {
          nodeQueue.offer(node.left)
          indexQueue.offer(index * 2)
        }
        // add right child
        if (null != node.right) {
          nodeQueue.offer(node.right)
          indexQueue.offer(index * 2 + 1)
        }
      }
      // after go through the entire level, calculate the current level and compare with result
      result = max(result, end - begin + 1) // rightmost - leftmost + 1 is the width of this level
    }

    return result
  }
}
