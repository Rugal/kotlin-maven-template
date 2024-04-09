package recoverbinarysearchtree

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
class Solution {
  fun recoverTreeBasic(root: TreeNode?): Unit {
    val l = mutableListOf<TreeNode>()

    var root = root
    val s = Stack<TreeNode>()
    while (root != null || s.isNotEmpty()) {
      while (root != null) {
        s.push(root)
        root = root.left
      }

      if (s.isNotEmpty()) {
        root = s.pop()
        l.add(root)
        root = root.right
      }
    }
//    l.forEach { println(it.`val`) }
    lateinit var right: TreeNode
    for (i in l.size - 1 downTo 0) {
      if (l[i - 1].`val` > l[i].`val`) {
        right = l[i]
        break
      }
    }
    println(right.`val`)
    lateinit var left: TreeNode
    for (i in l) {
      if (i.`val` > right.`val`) {
        left = i
        break
      }
    }

    val temp = left.`val`
    left.`val` = right.`val`
    right.`val` = temp
  }

  private var right: TreeNode? = null
  private var foundRight = false
  private var left: TreeNode? = null
  private var foundLeft = false

  /**
   * Traverse tree in reverse inorder way.
   * Find the first element that is smaller than its predecessor(if regular inorder traversal)
   */
  private fun findRight(root: TreeNode?) {
    if (null == root || foundRight) return
    this.findRight(root.right)

    // found the wrong right node
    if (null != right && root.`val` > right!!.`val`) {
      foundRight = true
      return
    }

    if (foundRight) return
    right = root
    this.findRight(root.left)
  }

  /**
   * Traverse tree in regular inorder way.
   * Find the first element that is greater than `right` element. That is the wrong node.
   */
  private fun findLeft(root: TreeNode?) {
    if (null == root || foundLeft) return
    this.findLeft(root.left)

    if (null != left && left!!.`val` > right!!.`val`) {
      foundLeft = true
      return
    }

    if (foundLeft) return
    left = root
    this.findLeft(root.right)
  }

  fun recoverTree(root: TreeNode?) {
    this.findRight(root)
    this.findLeft(root)

    val temp = this.right!!.`val`
    this.right!!.`val` = this.left!!.`val`
    this.left!!.`val` = temp
  }
}
