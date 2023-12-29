package numberofislands

/**
 * 200. Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/
 */
class Solution {
  private var grid: Array<CharArray> = arrayOf()
  private var visited: Array<BooleanArray> = arrayOf()

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
    && this.grid[row][column] == '1'

  private fun dfs(row: Int, column: Int) {
    this.visited[row][column] = true

    this.directions
      .map { row + it[0] to column + it[1] }
      .filter { this.isVisitable(it.first, it.second) }
      .forEach { this.dfs(it.first, it.second) }
  }

  fun numIslands(grid: Array<CharArray>): Int {
    this.grid = grid
    this.visited = Array(this.grid.size) { BooleanArray(this.grid[0].size) }
    var result = 0

    for (row in 0 until this.grid.size) {
      for (column in 0 until this.grid[0].size) {
        if (this.isVisitable(row, column)) {
          this.dfs(row, column)
          result++
        }
      }
    }

    return result
  }
}
