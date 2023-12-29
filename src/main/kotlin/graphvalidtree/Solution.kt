package graphvalidtree

class Solution {
  fun validTree(n: Int, edges: Array<IntArray>): Boolean {
    // Condition 1: The graph must contain n - 1 edges.
    if (edges.size != n - 1) return false;

    val us = UnionSet(n)

    for (e in edges) {
      // if they are already in the same group
      if (!us.union(e[0], e[1])) return false // so there is a cycle
    }

    return true
  }
}

class UnionSet(n: Int) {
  private val parent = IntArray(n) { it }
  private val rank = IntArray(n)

  fun find(i: Int): Int {
    if (this.parent[i] != i) {
      // do path compression to be performant
      parent[i] = this.find(parent[i])
    }
    return this.parent[i]
  }

  fun union(x: Int, y: Int): Boolean {
    val rx = this.find(x)
    val ry = this.find(y)
    // already in the same group
    if (rx == ry) return false
    // set new parent according to rank
    if (this.rank[rx] < this.rank[ry]) {
      // ry has higher rank, so set ry as parent of rx
      this.parent[rx] = ry
    } else { // break the tie
      // rx has same or higher rank, set rx as parent of ry
      this.parent[ry] = rx
      this.rank[rx]++
    }
    // however goes, x and y are now combined into same group
    return true
  }
}
