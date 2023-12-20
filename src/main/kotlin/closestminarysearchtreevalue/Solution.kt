package closestminarysearchtreevalue

import countgoodnodesinbinarytree.TreeNode
import kotlin.math.abs

class Solution {

  private var diff: Double = Double.MAX_VALUE

  private var target: Double = 0.0

  private lateinit var result: TreeNode


  /**
   * @param root: the given BST
   * @param target: the given target
   * @return: the value in the BST that is closest to the target
   */
  fun closestValue(root: TreeNode, target: Double): Int {
    this.result = root
    this.target = target
    this.diff = Double.MAX_VALUE

    this.traverse(root)

    return this.result.`val`
  }

  private fun traverse(root: TreeNode?) {
    if (null == root) {
      return
    }

    abs(root.`val` - target).also {
      if (it < diff) {
        diff = it
        result = root
      }
    }

    this.traverse(root.left)
    this.traverse(root.right)
  }
  
  fun closestValueIteration(r: TreeNode, target: Double): Int {
    var result = r.`val`
    var root: TreeNode? = r
    
    while (null != root) {
      // found better result
      if (abs(result - target) > abs(root.`val` - target)) {
        result = root.`val`
      }

      // only move to the close direction
      root = if (root.`val` < target) {
        root.right
      } else {
        root.left
      }
    }

    return result
  }
}
