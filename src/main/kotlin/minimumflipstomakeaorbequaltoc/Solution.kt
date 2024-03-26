package minimumflipstomakeaorbequaltoc

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 */
class Solution {
  fun minFlips(a: Int, b: Int, c: Int): Int {
    if (a + b == c) return 0

    var a = a
    var b = b
    var c = c

    var count = 0
    while (a > 0 || b > 0 || c > 0) {
      count += (if (0 == c % 2) a % 2 + b % 2 else if ((a % 2 + b % 2) > 0) 0 else 1)
      a /= 2
      b /= 2
      c /= 2
    }
    return count
  }
}
