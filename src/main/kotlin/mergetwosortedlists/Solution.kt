package mergetwosortedlists

import reverselinkedlist.ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {

  fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? = if (l1 != null && l2 != null) {
    if (l1.`val` < l2.`val`) {
      l1.next = mergeTwoLists(l1.next, l2) // use this value to point to following list
      l1 // the next value 
    } else {
      l2.next = mergeTwoLists(l1, l2.next)
      l2
    }
  } else l1 ?: l2 // the remaining
}
