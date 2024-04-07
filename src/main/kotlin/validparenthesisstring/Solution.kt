package validparenthesisstring

import kotlin.math.max

/**
 * https://leetcode.com/problems/valid-parenthesis-string
 */
class Solution {
  fun checkValidString(s: String): Boolean {
    // min and max bound for number of open bracket
    var minimum = 0
    var maximum = 0
    for (element in s) {
      // lower bound can only be incremented by (, otherwise will decrement but always be non-negative
      minimum += if (element == '(') 1 else -1
      // upper bound can be decremented by ), otherwise will increment
      maximum += if (element == ')') -1 else 1
      // if upper bound is negative means there is no way to balance the parenthesis at all
      if (maximum < 0) break
      // to set non-negative
      minimum = max(minimum, 0) // reset to 0 since some character could be *
    }
    return minimum == 0
  }
}
