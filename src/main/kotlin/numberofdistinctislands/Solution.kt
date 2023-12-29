package numberofdistinctislands

/**
 * https://leetcode.com/problems/number-of-distinct-islands/
 */
class Solution {
  private var grid: Array<IntArray> = arrayOf()
  private var visited: Array<BooleanArray> = arrayOf()
  private val result = mutableSetOf<String>()
  private val pattern = StringBuilder()

  private val directions: Array<IntArray> =
    arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

  /**
   * 1. row and column valid.<BR>
   * 2. never visit before.<BR>
   * 3. is land.
   */
  private fun isVisitable(row: Int, column: Int): Boolean = ((row in 0 until this.grid.size)
    && (column in 0 until this.grid[0].size))
    && !this.visited[row][column]
    && this.grid[row][column] == 1

  private fun dfs(row: Int, column: Int) {
    this.visited[row][column] = true

    for ((index, d) in this.directions.withIndex()) {
      val pair = row + d[0] to column + d[1]
      if (this.isVisitable(pair.first, pair.second)) {
        this.pattern.append("$index")
        this.dfs(pair.first, pair.second)
      }
    }
    /*
     some pattern does look the same if does not record the path
      --
       |
       |
       -

      --
       |
       |-

      --
       |-
       |
     */

    this.pattern.append("9") // must add indicator here to denote the exit of function
  }

  fun numDistinctIslands(grid: Array<IntArray>): Int {
    this.grid = grid
    this.visited = Array(this.grid.size) { BooleanArray(this.grid[0].size) }
    this.result.clear()
    this.pattern.clear()

    for (row in 0 until this.grid.size) {
      for (column in 0 until this.grid[0].size) {
        if (this.isVisitable(row, column)) {
          this.dfs(row, column)
          this.result.add(this.pattern.toString())
          this.pattern.clear()
        }
      }
    }

    return result.size
  }
}
