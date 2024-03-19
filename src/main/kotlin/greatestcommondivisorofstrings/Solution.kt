package greatestcommondivisorofstrings

import kotlin.math.min

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings
 */
class Solution {

  /**
   * if origin is dividable by sub.
   * after repeating many times, it should resemble the original string
   */
  private fun gcd(origin: String, sub: String): Boolean =
    if (origin.length % sub.length != 0) false
    else sub.repeat(origin.length / sub.length) == origin

  fun gcdOfStrings(str1: String, str2: String): String {
    val builder = StringBuilder()
    var result = ""

    for (i in 0 until min(str1.length, str2.length)) {
      if (str1[i] != str2[i]) break

      builder.append(str1[i])
      if (this.gcd(str1, builder.toString()) && this.gcd(str2, builder.toString())) {
        result = builder.toString()
      }
    }

    return result
  }
}
