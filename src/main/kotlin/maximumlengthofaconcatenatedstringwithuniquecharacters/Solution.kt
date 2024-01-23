package maximumlengthofaconcatenatedstringwithuniquecharacters

import kotlin.math.max


/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
 */
class Solution {

  private fun Char.toIndex(): Int = this - 'a'

  fun maxLength(arr: List<String>): Int {
    val dp: MutableList<Int> = ArrayList()
    dp.add(0)
    var res = 0
    for (s in arr) {
      var a = 0
      var dup = 0
      for (c in s) {
        dup = dup or (a and (1 shl c.toIndex()))
        a = a or (1 shl c.toIndex())
      }
      // duplicated in single string like aaaa
      if (dup > 0) continue
      for (i in dp.indices.reversed()) {
        // contains duplication
        if ((dp[i] and a) > 0) continue
        dp.add(dp[i] or a)
        // count how many character we have without duplication
        res = max(res, Integer.bitCount(dp[i] or a))
      }
    }
    return res
  }
}
