package reversevowelsofastring

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string
 */
val VOWEL = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

class Solution {
  fun reverseVowels(s: String): String {
    val array = s.toCharArray()

    var left = 0
    var right = array.size - 1
    while (left < right) {
      // try to find next possible vowel
      while (left < array.size && !VOWEL.contains(array[left])) {
        ++left
      }
      while (right >= 0 && !VOWEL.contains(array[right])) {
        --right
      }
      if (left >= right) {
        break
      }
      // swap vowel
      val temp = array[left]
      array[left] = array[right]
      array[right] = temp
      // move forward for next round
      ++left
      --right
    }

    return array.concatToString()
  }
}
