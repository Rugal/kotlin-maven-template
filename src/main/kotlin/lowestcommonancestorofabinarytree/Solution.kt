package lowestcommonancestorofabinarytree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
class Solution {

  private var result: TreeNode? = null

  /**
   * Either on left, or on right or both left and right.
   * The last possibility is the one we are looking for
   */
  private fun dfs(root: TreeNode?, p: TreeNode, q: TreeNode): Boolean {
    if (null == root) {
      return false
    }
    // if any node is the current node
    val mid = if (p == root || q == root) 1 else 0
    // if any node is at left tree
    val left = if (this.dfs(root.left, p, q)) 1 else 0
    // if any node is at right tree
    val right = if (this.dfs(root.right, p, q)) 1 else 0
    val count = mid + left + right
    if (count > 1) {
      /*
        if any condition matched
        1. if p/q is the ancestor of another node
        2. if p and q is at left and right subtree of some node
        
        p
        | \
        |  q
        
        or
        
        x
        | \
        |  \
        p   q
        
        only when matching conditions above could we determine it is LCA
       */
      this.result = root
    }
    return count > 0
  }

  fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    this.dfs(root, p!!, q!!)
    return this.result
  }
}
