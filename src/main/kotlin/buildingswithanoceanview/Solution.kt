package buildingswithanoceanview

class Solution {
  fun findBuildings(heights: IntArray): IntArray {
    var bar = heights[heights.size - 1]
    val result = mutableListOf<Int>()

    result.add(heights.size - 1)
    for (i in heights.size - 2 downTo 0) {
      if (heights[i] > bar) {
        result.add(i)
        bar = heights[i]
      }
    }

    return result.sorted().toIntArray()
  }
}
