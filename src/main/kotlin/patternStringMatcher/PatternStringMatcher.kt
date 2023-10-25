package patternStringMatcher

class Solution {
  fun patternStr(pattern: String, text: String): Boolean {
    val map = mutableMapOf<Char, String>()

    val split = text.split(" ")
    pattern.toCharArray().forEachIndexed { index, c ->
      if (!map.containsKey(c)) {
        map[c] = split[index]
      } else {
        if (map[c] != split[index]) {
          return false
        }
      }
    }
    return true
  }
}
