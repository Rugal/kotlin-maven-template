package wordbreak

/**
 * https://leetcode.com/problems/word-break/
 *
 * @author Rugal Bernstein
 */
class Solution {

  fun wordBreak1(s: String, wordDict: List<String>): Boolean {
    val set = wordDict.toSet()
    val result = BooleanArray(s.length + 1) { it == 0 }

    for (current in 1..s.length) { // substring excludes right
      for (i in 0 until current) {
        // search all prefix to see if any string can match 0~i and i~current
        if (result[i] && set.contains(s.substring(i, current))) {
          result[current] = true
          break // if at least one matched, means it is solvable
        }
      }
    }

    return result[s.length]
  }
}
