package coinchangeii

class Solution {
  fun change(amount: Int, coins: IntArray): Int {
    IntArray(amount + 1) { if (it == 0) 1 else 0 }.let { result ->
      coins.forEach { coin ->
        (coin..amount).forEach { i ->
          result[i] += result[i - coin]
        }
      }

      return result[amount]
    }
  }
}
