package singlenumberii

/**
 * https://leetcode.com/problems/single-number-ii
 */
class Solution {
  fun singleNumber(nums: IntArray): Int {
    var once = 0
    var twice = 0

    nums.forEach { i ->
      once = once xor (i and twice.inv())
      twice = twice xor (i and once.inv())
    }

    return once
  }

  fun singleNumber_tailrec(nums: IntArray): Int {
    tailrec fun compute(once: Int, twice: Int, index: Int): Int = if (index >= nums.size) once
    else {
      val newOnce = once xor (nums[index] and twice.inv())
      compute(newOnce, twice xor (nums[index] and newOnce.inv()), index + 1)
    }

    return compute(0, 0, 0)
  }

  fun singleNumber_fold(nums: IntArray): Int {
    fun c(a: Int, b: Int, i: Int): Int = a xor (b.inv() and i)
    return nums.fold(0 to 0) { acc, i ->
      c(acc.first, acc.second, i).let { it to c(acc.second, it, i) }
    }.first
  }
}
