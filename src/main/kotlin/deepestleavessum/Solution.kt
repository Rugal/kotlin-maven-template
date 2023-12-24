package deepestleavessum

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun deepestLeavesSum(root: TreeNode?): Int {
    var result = 0
    if (null == root) return result

    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
      // clear for each new level, will leave the last level
      result = 0
      // for each level
      val size = queue.size
      for (i in 0 until size) {
        val current = queue.poll()
        // sum up this level
        result += current.`val`
        // prepare for next level
        current.left?.let(queue::offer)
        current.right?.let(queue::offer)
      }
    }

    return result
  }
}
