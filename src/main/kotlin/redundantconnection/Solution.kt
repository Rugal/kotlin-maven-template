package redundantconnection

/**
 * https://leetcode.com/problems/redundant-connection/
 */
class Solution {
  fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val ufs = UnionFindSet(edges.size)
    for (e in edges) {
      if (!ufs.union(e[0], e[1])) {
        return e
      }
    }
    return intArrayOf()
  }
}

@Suppress("DuplicatedCode")
private class UnionFindSet(n: Int) {
  private val parent = IntArray(n + 1) { it }
  private val rank = IntArray(n + 1)

  fun find(i: Int): Int {
    if (this.parent[i] != i) {
      this.parent[i] = this.find(this.parent[i])
    }
    return this.parent[i]
  }

  fun union(x: Int, y: Int): Boolean {
    val rx = this.find(x)
    val ry = this.find(y)

    // already in one group, no need to merge
    if (rx == ry) return false
    if (this.rank[rx] < this.rank[ry]) {
      // move one element to another group if rank higher
      this.parent[rx] = ry
    } else {
      // otherwise increase rx rank
      this.parent[ry] = rx
      this.rank[rx]++
    }

    return true
  }
}
