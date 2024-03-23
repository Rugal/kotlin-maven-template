package nthtribonaccinumber

/**
 * https://leetcode.com/problems/n-th-tribonacci-number
 */
class Solution {
  fun tribonacci(n: Int): Int {
    val data = intArrayOf(0, 1, 1)
    if (n < 3) return data[n]

    for (i in 3..n) {
      val t = data.sum()
      data[0] = data[1]
      data[1] = data[2]
      data[2] = t
    }

    return data[2]
  }
}
