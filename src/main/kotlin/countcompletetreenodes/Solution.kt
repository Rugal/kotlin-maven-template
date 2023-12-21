package countcompletetreenodes

import countgoodnodesinbinarytree.TreeNode

class Solution {

  private fun getHeight(r: TreeNode?): Int {
    if (null == r) {
      return -1
    }

    var height = 0
    var r: TreeNode = r
    while (null != r.left) {
      height++
      r = r.left!!
    }

    return height
  }
  
  fun countNodes(r: TreeNode?): Int {
    var r: TreeNode? = r
    var height = this.getHeight(r)
    var result = 0
    while (null != r) {
      if (this.getHeight(r.left) == this.getHeight(r.right)) {
        result += 1 shl height
        r = r.right
      } else {
        result += 1 shl height - 1
        r = r.left
      }

      height--
    }
    return result
  }
}
