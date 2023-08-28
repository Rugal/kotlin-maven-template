package coinchange

class Solution {
  fun coinChange(coins: IntArray, amount: Int): Int {
    val result = IntArray(amount + 1) { if (it > 0) Int.MAX_VALUE else 0 }
    (1..amount).forEach { i ->
      coins.forEach { coin ->
        (i - coin).also { remain ->
          if (remain >= 0 && result[remain] != Int.MAX_VALUE && result[remain] + 1 < result[i]) {
            result[i] = result[remain] + 1
          }
        }
      }
    }
    return result[amount].let { if (it == Int.MAX_VALUE) -1 else it }
  }
}
