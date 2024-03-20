package maxnumberofksumpairs

import kotlin.math.min

class Solution {
  fun maxOperations(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()

    for (i in nums) {
      map[i] = map.getOrDefault(i, 0) + 1
    }

    var result = 0

    for (i in nums) {
      if (i !in map || k - i !in map) continue
      result += if (2 * i == k) (map[i]!! / 2) else min(map[i]!!, map[k - i]!!)
      map.remove(i)
      map.remove(k - i)
    }

    return result
  }
}
