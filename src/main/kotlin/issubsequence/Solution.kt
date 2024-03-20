package issubsequence

class Solution {
  fun isSubsequence(sub: String, text: String): Boolean {
    var i = 0
    var j = 0
    while (i < sub.length && j < text.length) {
      if (sub[i] == text[j]) {
        ++i
      }
      ++j
    }
    return i == sub.length
  }
}
