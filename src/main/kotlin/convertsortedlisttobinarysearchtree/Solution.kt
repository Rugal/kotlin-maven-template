package convertsortedlisttobinarysearchtree

import countgoodnodesinbinarytree.TreeNode

data class ListNode(
  var `val`: Int,
  var next: ListNode? = null,
)

class Solution {
  fun sortedListToBST(head: ListNode?): TreeNode? {
    var root: TreeNode? = null
    if (null == head) return root

    var head = head

    var fast: ListNode? = head
    var slow: ListNode = head
    var previous: ListNode? = null

    // use fast-slow pointer to find the middle element of this list
    while (fast?.next != null) {
      previous = slow
      slow = slow.next!!
      fast = fast.next!!.next
    }
    // use slow as root of this tree
    root = TreeNode(slow.`val`)
    if (previous != null) {
      // previous is not null, break it so next recursion won't have issue
      previous.next = null
    } else {
      // there is no previous at all, mean there is only no more element on left
      head = null
    }

    // left part as left subtree, must set the rightmost node.next as null
    root.left = this.sortedListToBST(head)
    // right part as right subtree
    root.right = this.sortedListToBST(slow.next)

    return root
  }
}
