package generateparentheses

class Solution {
  private val result = mutableListOf<String>()

  private var pair = 0

  fun generateParenthesis(n: Int): List<String> {
    this.pair = n
    this.result.clear()
    return this.backtrack("", 0, 0)
  }

  private fun backtrack(text: String, open: Int, close: Int): MutableList<String> {
    if (open + close == this.pair * 2) {
      this.result.add(text)
      return this.result
    }

    // still available for more open
    if (open < this.pair) {
      this.backtrack("$text(", open + 1, close)
    }

    if (open > close) {
      this.backtrack("$text)", open, close + 1)
    }

    return this.result
  }
}
