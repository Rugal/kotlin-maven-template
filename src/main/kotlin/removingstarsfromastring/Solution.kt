package removingstarsfromastring

import java.util.Stack

/**
 * https://leetcode.com/problems/removing-stars-from-a-string
 */
class Solution {
  fun removeStars(input: String): String {
    val s = Stack<Char>()

    for (i in input) {
      if (i == '*') {
        s.pop()
      } else {
        s.push(i)
      }
    }
    
    return s.joinToString(separator = "")
  }
}
