package uniquenumberofoccurrences

/**
 * https://leetcode.com/problems/unique-number-of-occurrences
 */
class Solution {
  fun uniqueOccurrences(arr: IntArray): Boolean {
    val m = mutableMapOf<Int, Int>()
    for (i in arr) {
      m[i] = m.getOrDefault(i, 0) + 1
    }

    return m.values.let {
      it.toSet().size == it.size
    }
  }
}
