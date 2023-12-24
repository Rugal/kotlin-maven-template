package inordersuccessorinbst

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
class Solution {
  /**
   * means final result(inorder successor) is found
   */
  private var solved = false

  /**
   * means target p is found in tree
   */
  private var found = false
  private var result: TreeNode? = null
  private var target: TreeNode? = null

  private fun dfs(root: TreeNode?) {
    // early exit if completed
    if (solved || null == root) return

    this.dfs(root.left)
    if (root.`val` == this.target!!.`val`) {
      this.found = true
    }
    // must not be the same node
    if (found && root.`val` != target!!.`val` && !solved) {
      this.solved = true
      this.result = root
    }
    this.dfs(root.right)
  }

  fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
    this.target = p
    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }

  fun inorderSuccessorIteration(root: TreeNode?, p: TreeNode?): TreeNode? {
    var result: TreeNode? = null
    var root = root

    while (null != root) {
      // currently on the left side of p
      if (root.`val` <= p!!.`val`) {
        root = root.right
      } else {
        // find one that is greater than p
        result = root
        root = root.left
      }
    }

    return result
  }
}
