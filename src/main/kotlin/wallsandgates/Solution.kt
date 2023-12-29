package wallsandgates

class Solution {
  private var rooms: Array<IntArray> = arrayOf()

  private val directions: Array<IntArray> =
    arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

  private fun isVisitable(row: Int, column: Int): Boolean = row in 0 until this.rooms.size
    && column in 0 until this.rooms[0].size
    && this.rooms[row][column] > 0

  private fun dfs(row: Int, column: Int, distance: Int) {
    // is gate itself, or does not provide better solution
    if (this.rooms[row][column] != 0 && distance >= this.rooms[row][column]) return // no need to check neighbour as well

    // is not gate itself, and is room need update
    if (this.rooms[row][column] > 0) {
      this.rooms[row][column] = distance
    }

    // and further bfs
    this.directions
      .map { row + it[0] to column + it[1] }
      .filter { this.isVisitable(it.first, it.second) }
      .forEach { this.dfs(it.first, it.second, distance + 1) }
  }

  fun wallsAndGates(rooms: Array<IntArray>) {
    this.rooms = rooms

    for ((r, row) in rooms.withIndex()) {
      for ((c, cell) in row.withIndex()) {
        if (cell == 0) {
          this.dfs(r, c, 0)
        }
      }
    }
  }
}
