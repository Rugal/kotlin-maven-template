package canplaceflowers

/**
 * https://leetcode.com/problems/can-place-flowers
 */
class Solution {
  fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    fun placeable(index: Int): Boolean =
      (index == 0 || flowerbed[index - 1] == 0) // left side should be empty or reaches the head
        // and  
        && (index == (flowerbed.size - 1) || flowerbed[index + 1] == 0) // right side should be empty or reaches the tail

    var n = n
    for (i in flowerbed.indices) {
      if (n == 0) break
      if (flowerbed[i] != 1 && placeable(i)) {
        n--
        flowerbed[i] = 1
      }
    }

    return n == 0
  }
}
