package maximumtwinsumofalinkedlist

import kotlin.math.max
import reverselinkedlist.ListNode

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 */
class Solution {
  fun pairSum(head: ListNode): Int {
    var count = 1
    var h: ListNode? = head
    while (h != null) {
      ++count
      h = h.next
    }
    
    val array = IntArray(count)

    h = head
    for (i in 0 until count) {
      array[i] = h!!.`val`
      h = h.next
    }
    var result = -1
    for (i in 0 until count / 2) {
      result = max(array[i] + array[count - i - 1], result)
    }
    return result
  }
}
