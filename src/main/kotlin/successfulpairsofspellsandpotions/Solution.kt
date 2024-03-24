package successfulpairsofspellsandpotions

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions
 */
class Solution {

  private fun bs(potions: IntArray, target: Long): Int {
    var left = 0
    var right = potions.size - 1
    while (left <= right) {
      val mid = left + (right - left) / 2
      if (potions[mid] >= target) { // find the left most target value
        right = mid - 1
      } else {
        left = mid + 1
      }
    }

    return right + 1
  }

  fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    potions.sort()
    return spells.map {
      var d: Long = success / it
      if (d * it < success) ++d
      potions.size - this.bs(potions, d)
    }.toIntArray()
  }
}
