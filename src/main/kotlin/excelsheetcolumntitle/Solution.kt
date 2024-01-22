package excelsheetcolumntitle

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
class Solution {

  /**
   * A + 25 => Z
   *
   * @param offset   0 ... 25
   */
  private fun shift(offset: Int): Char = 'A' + offset

  /**
   * A -> 1
   * B -> 2
   * C -> 3
   * ...
   * Z -> 26
   * AA -> 27
   * AB -> 28
   * ...
   */
  fun convertToTitle(columnNumber: Int): String {
    // 27 -> 26 ->  26 % 26 = 0 => A
    // 26 / 26 = 1 -> 0 -> 0 % 26 = 0 => A

    // 28 -> 27 -> 27 % 26 = 1 => B
    // 27 / 27 = 1 -> 0 -> 0 % 26 = 0 => A
    var n = columnNumber
    val sb = StringBuilder()

    while (n > 0) {
      sb.append(this.shift((n - 1) % 26))
      n = (n - 1) / 26
    }

    return sb.reverse().toString()
  }
}
