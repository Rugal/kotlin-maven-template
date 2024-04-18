package removenthnodefromendoflist

import convertsortedlisttobinarysearchtree.ListNode

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class Solution {
  fun removeNthFromEnd(head: ListNode, n: Int): ListNode? {
    val fake = ListNode(0)
    fake.next = head


    var previous = fake
    var tail: ListNode? = fake
    // move tail n node away from previous
    for (i in 0 until n) {
      if (null != tail) {
        tail = tail.next
      }
    }
    println("previous ${previous.`val`} tail ${tail!!.`val`}")

    while (null != tail!!.next) {
      previous = previous.next!!
      tail = tail.next
    }

    previous.next = previous.next!!.next
    return fake.next
  }
}
