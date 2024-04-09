package inordersuccessorinbstii

class Node(var `val`: Int) {
  var left: Node? = null
  var right: Node? = null
  var parent: Node? = null
}

/**
 * https://leetcode.com/problems/inorder-successor-in-bst-ii/
 */
class Solution {
  fun inorderSuccessor(node: Node?): Node? {
    if (null == node) return null

    var result: Node?
    if (null != node.right) {
      result = node.right
      while (null != result!!.left) {
        result = result.left
      }
      return result
    }

    var node = node
    while (null != node!!.parent     // parent is not null
      && node.parent!!.right == node // parent is smaller(current is right subtree of parent)
    ) {
      node = node.parent //climb along parent path
    }
    return node.parent // either null or first time bigger than node
  }
}
