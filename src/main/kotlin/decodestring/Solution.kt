package decodestring

import java.util.Stack

/**
 * https://leetcode.com/problems/decode-string
 */
class Solution {
  fun decodeString(input: String): String {
    // 3[a2[c]]
    // 3[a]2[bc]
    // 3[z]2[2[y]pq4[2[jk]e1[f]]]ef
    // zzz2[yypq4[jkjkef]]ef

    val s = Stack<StringBuilder>()
    for (c in input) {
      if (c.isDigit()) {
        if (s.isEmpty() // first character
          || s.peek().last().let { it.isLowerCase() || it == ']' || it == '['}) { // is not number
          s.push(StringBuilder().append(c))
        } else {
          // is number
          s.peek().append(c)
        }
        continue
      }
      if (c.isLowerCase()) {
        if (s.isEmpty() || s.peek()[0] == '[') {
          // [a
          s.push(StringBuilder().append(c))
        } else {
          // [abc
          s.peek().append(c)
        }
        continue
      }
      if (c == '[') {
        s.push(StringBuilder("["))
        continue
      }
      // actually process string
      val text = s.pop()
      s.pop()
      
      val repeat = s.pop().toString().toInt()
      val new = text.repeat(repeat)
      if (s.isEmpty() || s.peek().last() == '[') {
        s.push(StringBuilder(new))
        continue
      } else {
        s.peek().append(new)
      }
    }
    return s.first().toString()
  }
}
