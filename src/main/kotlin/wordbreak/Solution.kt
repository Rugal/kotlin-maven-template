package wordbreak

/**
 * https://leetcode.com/problems/word-break/solution/
 *
 * @author Rugal Bernstein
 */
class Solution {
  fun wordBreak(s: String, wordDict: List<String>): Boolean {

    val set = wordDict.toSet()
    val result = BooleanArray(s.length + 1)
    result[0] = true

    for (current in 1 until result.size) {
      for (i in 0 until current) {
        if (result[i] && set.contains(s.substring(i, current))) {
          result[current] = true
          // if at least one matched, means it is solvable
          break
        }
      }
    }
    return result[s.length]
  }
}
