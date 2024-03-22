package oddevenlinkedlist

import reverselinkedlist.ListNode

/**
 * https://leetcode.com/problems/odd-even-linked-list
 */
class Solution {
  fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null || null == head.next!!.next) return head

    var odd = head
    var even = head.next
    val evenHead = even

    while (even?.next != null) {
      odd!!.next = even.next
      even.next = even.next!!.next
      odd = odd.next
      even = even.next
    }
    odd!!.next = evenHead
    return head
  }
}
