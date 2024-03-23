package numberofprovinces

/**
 * https://leetcode.com/problems/number-of-provinces
 */
class Solution {
  fun findCircleNum(isConnected: Array<IntArray>): Int {
    val set = UnionFindSet(isConnected.size)
    // how many separate city
    var city = isConnected.size

    for (r in isConnected.indices) {
      for (c in isConnected.indices) {
        if (isConnected[r][c] == 0) {
          continue
        }
        if (set.union(r, c)) {
          --city
        }
      }
    }

    return city
  }
}

class UnionFindSet(val size: Int) {

  private val parent = IntArray(size + 1) { it }
  private val rank = IntArray(size + 1)

  /**
   * Find which parent/group a target belongs to
   */
  fun find(target: Int): Int {
    // if grouping is not the shortest
    if (this.parent[target] != target) {
      // try to optimize the path
      this.parent[target] = this.find(this.parent[target])
    }
    return this.parent[target]
  }

  fun union(x: Int, y: Int): Boolean {
    val px = this.find(x)
    val py = this.find(y)

    if (px == py) return false

    if (this.rank[px] < this.rank[py]) {
      this.parent[px] = py
    } else {
      this.parent[py] = px
      this.rank[px]++
    }

    return true
  }
}
