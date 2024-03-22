package numberofrecentcalls

import java.util.LinkedList
import java.util.Queue

private const val TIMEOUT = 3000

class RecentCounter {
  private val queue: Queue<Int> = LinkedList()

  fun ping(t: Int): Int {
    this.queue.offer(t)
    while (this.queue.isNotEmpty() && t - this.queue.peek() > TIMEOUT) {
      this.queue.poll()
    }
    return this.queue.size
  }
}
