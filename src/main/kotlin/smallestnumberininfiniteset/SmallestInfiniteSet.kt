package smallestnumberininfiniteset

import java.util.PriorityQueue
import java.util.Queue

/**
 * https://leetcode.com/problems/smallest-number-in-infinite-set
 */
class SmallestInfiniteSet {
  private val queue: Queue<Int> = PriorityQueue { a, b -> a - b }
  private var maximum = 1

  fun popSmallest(): Int = if (this.queue.isEmpty()) this.maximum++ else this.queue.poll()

  fun addBack(num: Int) {
    if (num < this.maximum && !this.queue.contains(num)) {
      this.queue.offer(num)
    }
  }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
