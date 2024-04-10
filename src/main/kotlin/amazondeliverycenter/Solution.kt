package amazondeliverycenter

import kotlin.math.abs

class Solution {
  private fun possible(location: Int, center: Array<Int>, d: Long): Boolean {
    var distance = 0L

    for (c in center) distance += 2 * abs(c - location)

    return distance <= d
  }

  private fun onLeft(middle: Int, center: Array<Int>, d: Long): Int {
    println("on left")
    var left = (center.min() - d / 2).toInt()
    var right = middle

    while (left < right) {
      val mid = left + (right - left) / 2
      println("left $left mid $mid right $right")
      /*
        [xxxxxxxx.......................]
        [xxxxxxxx.........]
        [xxxxxxxx.]
        [xxx.]
        [x.]
       */
      if (possible(mid, center, d)) right = mid else left = mid + 1
    }

    return left
  }

  private fun onRight(middle: Int, center: Array<Int>, d: Long): Int {
    println("on right")
    var left = middle
    var right = (center.max() + d / 2).toInt()

    while (left < right) {
      val mid = left + (right - left) / 2

      println("left $left mid $mid right $right")

      if (possible(mid, center, d)) {
        if (left == mid)
          break
        left = mid
      } else right = mid - 1
    }

    return right
  }

  fun suitableLocations(center: Array<Int>, d: Long): Int {
    val middle = center.average().toInt()

    // unable to fulfill even at middle point
    if (!this.possible(middle, center, d)) return 0
    return this.onRight(middle, center, d) - this.onLeft(middle, center, d) + 1
  }
}




