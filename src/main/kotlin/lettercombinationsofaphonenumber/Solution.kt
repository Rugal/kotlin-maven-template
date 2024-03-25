package lettercombinationsofaphonenumber

private val KEYBOARD = listOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
class Solution {

  private var result = mutableListOf<String>()

  fun letterCombinations(digits: String): List<String> {
    if (digits.isBlank()) return listOf()

    this.result.clear()

    this.result.add("")

    for (d in digits) {
      val temp = mutableListOf<String>()
      for (c in KEYBOARD[d - '0']) { // get corresponding characters of target number
        for (r in result) { // append character in every single result from previous stage
          temp.add(r + c)
        }
      }

      this.result = temp
    }

    return this.result
  }
}
