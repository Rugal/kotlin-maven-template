package maximumnumberofvowelsinasubstringofgivenlength

import kotlin.math.max

val VOWEL = setOf('a', 'e', 'i', 'o', 'u')

class Solution {
  fun maxVowels(s: String, k: Int): Int {
    var result = 0
    var count = 0

    for (i in 0 until k) {
      if (VOWEL.contains(s[i])) {
        ++count
      }
    }

    var left = 0
    var right = k - 1
    while (right < s.length) {
      // if has k element in window, calculate average
      if (right - left + 1 == k) {
        result = max(result, count)
      }

      if (VOWEL.contains(s[left++])) {
        --count
      }
      if (++right < s.length && VOWEL.contains(s[right])) {
        ++count
      }
    }
    return result
  }
}
