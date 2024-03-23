package maximumlevelsumofabinarytree

import java.util.LinkedList
import java.util.Queue
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun maxLevelSum(root: TreeNode): Int {
    val q: Queue<TreeNode> = LinkedList()
    var maxSum = Int.MIN_VALUE
    var result = 0
    var level = 0
    q.offer(root)

    while (q.isNotEmpty()) {
      ++level
      val size = q.size
      var sum = 0
      for (i in 0 until size) {
        val poll = q.poll()
        sum += poll.`val`
        poll.left?.also { q.offer(it) }
        poll.right?.also { q.offer(it) }
      }
      if (sum > maxSum) {
        maxSum = sum
        result = level
      }
    }

    return result
  }
}
