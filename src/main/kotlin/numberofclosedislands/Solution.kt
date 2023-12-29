package numberofclosedislands

private const val water = 1
private const val land = 0

class Solution {

  private var grid: Array<IntArray> = arrayOf()
  private var visited: Array<BooleanArray> = arrayOf()

  private val directions: Array<IntArray> =
    arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

  private fun isBoundary(row: Int, column: Int): Boolean =
    (row == 0 || row == this.grid.size - 1 || column == 0 || column == this.grid[0].size - 1)

  /**
   * 1. row and column valid.<BR>
   * 2. never visit before.<BR>
   * 3. is land.
   */
  private fun isVisitable(row: Int, column: Int): Boolean = ((row in 0 until this.grid.size)
    && (column in 0 until this.grid[0].size))
    && !this.visited[row][column]
    && this.grid[row][column] == land

  /**
   * Traverse graph by DFS.
   * @return false iff the entire DFS does not reach the graph boundary
   */
  private fun dfs(row: Int, column: Int): Boolean {
    this.visited[row][column] = true
    return this.directions
      .map { row + it[0] to column + it[1] }
      .filter { this.isVisitable(it.first, it.second) }
      .map { this.dfs(it.first, it.second) }
      .reduceOrNull { a, b -> a || b } ?: false
      || this.isBoundary(row, column) // 短路运算
  }

  fun closedIsland(grid: Array<IntArray>): Int {
    this.grid = grid
    this.visited = Array(this.grid.size) { BooleanArray(this.grid[0].size) }
    var result = 0

    for (row in 0 until this.grid.size) {
      for (column in 0 until this.grid[0].size) {
        if (this.isVisitable(row, column) && !this.dfs(row, column)) {
          result++
        }
      }
    }

    return result
  }
}
