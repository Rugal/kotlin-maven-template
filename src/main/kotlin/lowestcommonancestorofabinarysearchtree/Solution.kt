package lowestcommonancestorofabinarysearchtree

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
class Solution {
  fun dfs(root: TreeNode?, small: TreeNode, big: TreeNode): TreeNode? {
    if (null == root) return null
    if (root.`val` < small.`val`) return this.dfs(root.right, small, big) // both at right subtree
    if (big.`val` < root.`val`) return this.dfs(root.left, small, big) // both at left subtree
    return root // one at left, one at right. hence this root is the LCA
  }

  fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode? {
    val pair = if (p!!.`val` < q!!.`val`) p to q else q to p
    return this.dfs(root, pair.first, pair.second)
  }
}
