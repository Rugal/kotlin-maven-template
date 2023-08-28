package reverselinkedlist

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
  fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) {
      // make sure there are at least 2 nodes
      return head
    }
    // given there are 2 nodes
    var previous: ListNode? = null
    var current: ListNode? = head
    var next: ListNode? = current!!.next

    while (null != current) {
      // reverse pointer
      current.next = previous
      // move to next pointer
      previous = current
      current = next
      next = next?.next
    }

    return previous
  }
}

class ListNode(var `val`: Int) {
  var next: ListNode? = null
}
