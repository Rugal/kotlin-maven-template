package besttimetobuyandsellstockwithtransactionfee

import kotlin.math.max

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
class Solution {
  fun maxProfit(prices: IntArray, fee: Int): Int {
    var cash = 0
    var hold = -100000 // we could have use Int.MIN_VALUE, but in order to avoid overflow

    for (i in prices.indices) {
      // best you can do to sell stock on this day (do not buy)
      cash = max(cash, hold + prices[i] - fee) // either sell or not sell, pick whichever higher
      // best you can do to hold stock on this day(do not sell)
      hold = max(hold, cash - prices[i]) // either buy or not buy, pick whichever higher
    }

    return cash
  }
}
