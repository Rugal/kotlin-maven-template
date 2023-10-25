package longestsubstringwithoutrepeatingcharacters

import kotlin.math.max

class Solution {
  fun lengthOfLongestSubstring(s: String): Int {
    val map = mutableMapOf<Char, Int>()
    var max = 0

    var left: Int = 0
    var right: Int = 0
    while (left <= right && right < s.length) {
      if (map.containsKey(s[right])) {
        // move all the way to left and update map
        for (i in left..<map[s[right]]!!) {
          map.remove(s[i])
        }
        left = map[s[right]]!! + 1
        map[s[right]] = right
      } else {
        map[s[right]] = right
        max = max(max, map.size)
        right++
      }
    }

    return max
  }
}
