package binarytreezigzaglevelordertraversal

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (null == root) return result

    val queue = LinkedList<TreeNode>()
    queue.offer(root)
    var left2Right = true

    while (queue.isNotEmpty()) {
      val size = queue.size
      val l = LinkedList<Int>()
      for (i in 0 until size) {
        val poll = queue.poll()
        poll.left?.let(queue::offer)
        poll.right?.let(queue::offer)

        if (left2Right) {
          l.addLast(poll.`val`)
        } else {
          l.addFirst(poll.`val`)
        } 
      }

      left2Right = !left2Right
      result.add(l)
    }

    return result
  }
}
