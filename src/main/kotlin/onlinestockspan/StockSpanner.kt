package onlinestockspan

import java.util.Stack

/**
 * https://leetcode.com/problems/online-stock-span
 */
class StockSpanner {

  private val s = Stack<Pair<Int, Int>>()

  /**
   * Need to record how many span for each element.
   * Hence, for each element, if it is smaller than top, just append it
   * otherwise, remove any element that is greater than it, and accumulate their span to current one
   */
  fun next(price: Int): Int {
    var span = 1
    // remove any top element that has cheaper than current price
    while (s.isNotEmpty() && s.peek().first <= price) {
      // accumulate previous span
      span += s.pop().second
    }
    // always add current price
    s.push(price to span)
    return span
  }
}
