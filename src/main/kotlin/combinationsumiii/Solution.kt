package combinationsumiii

/**
 * https://leetcode.com/problems/combination-sum-iii
 */
class Solution {
  private val result = mutableListOf<List<Int>>()

  private var remain: Int = 0

  private fun backtrack(temp: MutableList<Int>, target: Int, start: Int) {
    // to avoid too many elements
    if (temp.size > remain || target < 0) return
    // right number and sum for answer
    if (temp.size == remain && target == 0) {
      this.result.add(temp.toList())
      return
    }

    for (i in start..9) {
      if (temp.isEmpty() || temp.last() < i) {
        temp.add(i)
        this.backtrack(temp, target - i, i + 1)
        temp.removeLast()
      }
    }
  }

  fun combinationSum3(remain: Int, target: Int): List<List<Int>> {
    this.remain = remain
    this.result.clear()

    this.backtrack(mutableListOf(), target, 1)

    return this.result
  }
}
