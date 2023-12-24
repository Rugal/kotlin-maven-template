package findleavesofbinarytree

import java.util.LinkedList
import countgoodnodesinbinarytree.TreeNode

class Solution {
  private val g = Graph()

  private fun add(root: TreeNode?) {
    if (null == root) return

    if (null == root.left && null == root.right) {
      g.inDegree[root] = 0
      g.adjacency.putIfAbsent(root, LinkedList<TreeNode>())
      return
    }
    
    // add adjacency if has child
    root.left?.let { g.add(it, root) }
    root.right?.let { g.add(it, root) }

    // recurse to children
    this.add(root.left)
    this.add(root.right)
  }

  /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
  fun findLeaves(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    if (null == root) return result

    this.g.clear()

    this.add(root)

    val queue = LinkedList(this.g.inDegree.toList().filter { it.second == 0 }.map { it.first })

    while (queue.isNotEmpty()) {
      val size = queue.size
      val l = mutableListOf<Int>()
      for (i in 0 until size) {
        val current = queue.poll()
        // add this value to current level list
        l.add(current.`val`)

        // for each adjacent node
        this.g.adjacency[current]!!.forEach {
          // decrease as we remove current node
          this.g.inDegree[it] = this.g.inDegree[it]!! - 1
          // if there is no more inDegree
          if (0 == this.g.inDegree[it]) {
            // process this node in next round
            queue.offer(it)
          }
        }
      }

      result.add(l)
    }

    return result
  }
}

private class Graph {
  val inDegree = mutableMapOf<TreeNode, Int>()
  val adjacency = mutableMapOf<TreeNode, LinkedList<TreeNode>>()

  fun add(from: TreeNode, to: TreeNode) {
    /*
     * inDegree
     */
    // increment to inDegree by 1
    this.inDegree[to] = this.inDegree.getOrDefault(to, 0) + 1
    // initialize inDegree for from as well, but set to 0
    if (!this.inDegree.contains(from)) {
      this.inDegree[from] = 0
    }

    /*
     * adjacency
     */
    // first time seeing this `from`
    if (!this.adjacency.contains(from)) {
      this.adjacency[from] = LinkedList() // initialize its adjacency list
    }
    this.adjacency[from]!!.push(to) // also add relationship between them
    // initialize for to as well in case
    if (!this.adjacency.contains(to)) {
      this.adjacency[to] = LinkedList() // initialize its adjacency list
    }
  }

  fun clear() {
    this.inDegree.clear()
    this.adjacency.clear()
  }
}
