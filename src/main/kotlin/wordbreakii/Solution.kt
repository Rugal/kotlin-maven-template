package wordbreakii

/**
 * https://leetcode.com/problems/word-break-ii/
 *
 * @author rugal
 */
class Solution {
  private lateinit var candidates: Set<String>

  private val cache: MutableMap<String, List<String>> = HashMap()

  /**
   * To enhance performance, here we use map to cache repeated result.
   *
   * @param s
   * @param wordDict
   *
   * @return
   */
  fun wordBreak(s: String, wordDict: List<String>): List<String> {
    if (s.isEmpty()) return ArrayList()

    this.candidates = wordDict.toSet()
    return this.dfs(s)
  }

  private fun dfs(s: String): List<String> {
    if (cache.containsKey(s)) return cache[s]!!

    val result = ArrayList<String>()

    // the single word itself is candidate already
    if (candidates.contains(s)) result.add(s)
    
    // in worst case, there is no matching at all
    for (i in 1 until s.length) {
      // split string by index i, break into 2 parts
      val prefix = s.substring(0, i)
      // only if prefix match
      if (candidates.contains(prefix)) {
        for (t in this.dfs(s.substring(i))) { // all combination of suffix
          result.add("$prefix $t")
        }
      }
    }
    // we have gone through the all the possible combination of string s, now cache it and return
    cache[s] = result
    return result
  }
}
