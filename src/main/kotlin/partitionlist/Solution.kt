package partitionlist

import convertsortedlisttobinarysearchtree.ListNode

/**
 * https://leetcode.com/problems/partition-list/
 */
class Solution {

  fun partition(head: ListNode?, x: Int): ListNode? {
    if (null == head) return null

    val small = mutableListOf<Int>()
    val large = mutableListOf<Int>()

    var current: ListNode? = head

    while (current != null) {
      if (current.`val` < x) {
        small += current.`val`
      } else {
        large += current.`val`
      }

      current = current.next
    }

    current = head
    for (i in small) {
      current!!.`val` = i
      current = current.next
    }

    for (i in large) {
      current!!.`val` = i
      current = current.next
    }

    return head
  }
}
