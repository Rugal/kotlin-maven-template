package stepbystepdirectionsfromabinarytreenodetoanother

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/
 */
class Solution {
  private val sb = StringBuilder()

  private fun dfs(root: TreeNode?, value: Int): Boolean {
    if (null == root) return false
    if (root.`val` == value) return true

    sb.append("L")
    if (this.dfs(root.left, value)) return true
    sb.deleteCharAt(sb.length - 1)

    sb.append("R")
    if (this.dfs(root.right, value)) return true
    sb.deleteCharAt(sb.length - 1)

    return false
  }

  fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
    val lca = LCA().lowestCommonAncestor(root, startValue, destValue)
    // start from LCA
    this.sb.clear()
    // the starting value only up, so just count how many step and replace it with U
    this.dfs(lca, startValue)
    val left = "U".repeat(this.sb.toString().length)
    this.sb.clear()
    // the destination value would go down with left and right branching, so record them
    this.dfs(lca, destValue)

    return left + this.sb.toString()
  }
}

@Suppress("DuplicatedCode")
private class LCA {

  private var result: TreeNode? = null

  /**
   * Either on left, or on right or both left and right.
   * The last possibility is the one we are looking for
   */
  private fun dfs(root: TreeNode?, a: Int, b: Int): Boolean {
    if (null == root) {
      return false
    }
    // if any node is the current node
    val mid = if (a == root.`val` || b == root.`val`) 1 else 0
    // if any node is at left tree
    val left = if (dfs(root.left, a, b)) 1 else 0
    // if any node is at right tree
    val right = if (dfs(root.right, a, b)) 1 else 0

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

  fun lowestCommonAncestor(root: TreeNode?, a: Int, b: Int): TreeNode? {
    this.dfs(root, a, b)
    return this.result
  }
}
