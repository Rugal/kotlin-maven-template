package amazonacademy

class Solution {
  private fun possible(speed: Int, pages: Array<Int>, target: Int): Boolean {
    var day = 0
    for (p in pages) {
      day += p / speed
      if (p % speed != 0) day += 1
    }
    return day <= target
  }

  fun minimumNumberOfPages(pages: Array<Int>, days: Int): Int {
    var left = 1
    var right = 10001 // the tricky part
    while (left < right) {
      val mid = (left + right) / 2
      println("left $left right $right mid $mid")
      if (possible(mid, pages, days))
        right = mid
      else
        left = mid + 1
    }
    return if (left == 10001) -1 else left
  }
}
