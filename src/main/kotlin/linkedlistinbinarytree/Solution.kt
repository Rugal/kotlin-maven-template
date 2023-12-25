package linkedlistinbinarytree

import convertsortedlisttobinarysearchtree.ListNode
import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 */
class Solution {

  /**
   * Try match entire LinkedList non-stop
   */
  private fun dfs(head: ListNode?, root: TreeNode?): Boolean {
    // already reach the end of list
    if (null == head) return true
    // has more node but unable to match anymore
    if (null == root) return false
    // stop matching
    if (head.`val` != root.`val`) return false
    // match next node try both subtree
    return this.dfs(head.next, root.left) || this.dfs(head.next, root.right)
  }

  fun isSubPath(head: ListNode, root: TreeNode?): Boolean {
    if (null == root) return false

    // find first node, try matching the rest
    return if (head.`val` == root.`val` && this.dfs(head, root))
      true
    else // keep searching the first matching
      this.isSubPath(head, root.left) || this.isSubPath(head, root.right)
  }
}
