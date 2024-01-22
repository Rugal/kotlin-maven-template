package meetingroomsii

import java.util.Arrays
import java.util.PriorityQueue

class Solution {
  fun minMeetingRooms(intervals: Array<IntArray>): Int {
    val queue = PriorityQueue<Int>(intervals.size) { a, b -> a - b }
    Arrays.sort(intervals) { a, b -> a[0] - b[0] }

    queue.offer(intervals[0][1])

    for (i in 1 until intervals.size) {
      val item = intervals[i]
      if (queue.peek() <= item[0]) {
        queue.poll()
      }
      queue.offer(item[1])
    }
    return queue.size
  }
}
