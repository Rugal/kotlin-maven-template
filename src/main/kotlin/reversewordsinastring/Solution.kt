package reversewordsinastring

/**
 * https://leetcode.com/problems/reverse-words-in-a-string
 */
class Solution {
  fun reverseWords(s: String): String = s
    .split(" ")
    .filter { it.isNotBlank() }
    .reversed()
    .joinToString(separator = " ")
}
