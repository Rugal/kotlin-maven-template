package editdistance

import kotlin.math.min

/**
 * https://leetcode.com/problems/edit-distance
 */
class Solution {
  fun minDistance(word1: String, word2: String): Int {
    val distance = Array(word1.length + 1) { IntArray(word2.length + 1) }
    for (i in 0..word1.length) distance[i][0] = i
    for (i in 0..word2.length) distance[0][i] = i

    for (r in word1.indices) {
      for (c in word2.indices) {
        if (word1[r] == word2[c]) {
          // if 2 character match, means there is no need to change
          distance[r + 1][c + 1] = distance[r][c]
          continue
        }
        // the following changes are based on 'word1', to transform to 'word2'
        val replace = distance[r][c] + 1    // word1 to replace a character
        val insert = distance[r][c + 1] + 1 // word1 to add 1 more character
        val delete = distance[r + 1][c] + 1 // word1 to delete 1 character

        distance[r + 1][c + 1] = min(delete, min(replace, insert))
      }
    }
    return distance[word1.length][word2.length]
  }
}
