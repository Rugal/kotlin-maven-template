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
    // all list node matched
    if (null == head) return true
    // has more list node but unable to match tree node
    if (null == root) return false
    // no match now
    if (head.`val` != root.`val`) return false
    // match next node try either subtree
    return this.dfs(head.next, root.left) || this.dfs(head.next, root.right)
  }

  fun isSubPath(head: ListNode, root: TreeNode?): Boolean {
    if (null == root) return false

    // if first element matched, dfs from here
    return if (head.`val` == root.`val` && this.dfs(head, root))
      true
    else // otherwise, see if children can match first element
      this.isSubPath(head, root.left) || this.isSubPath(head, root.right)
  }
}
