package lowestcommonancestorofabinarysearchtree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class Solution {
  fun dfs(root: TreeNode?, small: TreeNode, big: TreeNode): TreeNode? {
    if (null == root) return null
    if (root.`val` < small.`val`) return this.dfs(root.right, small, big)
    if (big.`val` < root.`val`) return this.dfs(root.left, small, big)
    return root
  }

  fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {
    val pair = if (p!!.`val` < q!!.`val`) p to q else q to p
    return this.dfs(root, pair.first, pair.second)
  }
}
