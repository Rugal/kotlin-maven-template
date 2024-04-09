package populatingnextrightpointersineachnodeii

import java.util.LinkedList

class Node(var `val`: Int) {
  var left: Node? = null
  var right: Node? = null
  var next: Node? = null
}

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 */
class SolutionQueue {
  fun connect(root: Node?): Node? {
    if (null == root) return null

    val queue = LinkedList<Node>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
      val size = queue.size
      for (i in 0 until size) {
        val current = queue.poll()
        // if this level not empty, just point to the head; otherwise point to null        
        current.next = if (i < size - 1) queue.peek() else null
        current.left?.let(queue::offer)
        current.right?.let(queue::offer)
      }
    }

    return root
  }
}

private class SolutionRecursive {
  private var leftMost: Node? = null
  private var lastNode: Node? = null

  private fun child(root: Node?) {
    if (null == root) return

    if (this.lastNode != null) {
      // already work on this level
      this.lastNode!!.next = root
    } else {
      // its a brand new level, set leftMost
      this.leftMost = root
    }
    // in order to work for next neighbour
    this.lastNode = root
  }

  fun connect(root: Node?): Node? {
    if (null == root) return null
    // the root node is the done processing as it has no neighbour already
    this.leftMost = root

    while (null != this.leftMost) {
      // start processing this level
      var current = this.leftMost
      // reset lastNode to null to indicate a new level
      this.lastNode = null
      // reset leftMost to null, we have no idea about next level information yet
      // we will exit outer while loop if there is no more level
      this.leftMost = null
      // current level has more to process
      while (null != current) {
        // iterate from left to right
        this.child(current.left)
        this.child(current.right)
        current = current.next
      }
    }

    return root
  }
}
