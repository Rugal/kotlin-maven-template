package deletethemiddlenodeofalinkedlist

import reverselinkedlist.ListNode

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
 * 
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
  fun deleteMiddle(head: ListNode): ListNode? {
    if (head.next == null) return null

    var fast: ListNode? = head
    var slow = head
    while (fast?.next != null) {
      slow = slow.next!!
      fast = fast.next!!.next
    }

    fast = head
    while (fast!!.next != slow) {
      fast = fast.next
    }
    fast.next = slow.next

    return head
  }
}
