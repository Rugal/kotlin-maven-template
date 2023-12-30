package constructbinarysearchtreefrompreordertraversal

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private var preorder: IntArray = intArrayOf()

  private fun dfs(left: Int, right: Int): TreeNode? {
    if (left > right) return null
    // the left most element is the root value
    val root = TreeNode(this.preorder[left])

    // find the mid value that divide this subarray into 2 parts
    var mid = -1
    for (i in left..right) {
      mid = i
      if (this.preorder[i] > this.preorder[left]) {
        mid = i - 1
        break
      }
    }
    
    if (-1 != mid) {
      // find left subtree part
      // left -> mid
      root.left = this.dfs(left + 1, mid)
      // find right subtree part
      // mid + 1 -> right
      root.right = this.dfs(mid + 1, right)
    }

    return root
  }

  fun bstFromPreorder(preorder: IntArray): TreeNode? {
    this.preorder = preorder

    return this.dfs(0, this.preorder.size - 1)
  }
}
