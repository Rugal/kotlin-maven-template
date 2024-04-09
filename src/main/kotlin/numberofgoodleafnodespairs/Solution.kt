package numberofgoodleafnodespairs

import countgoodnodesinbinarytree.TreeNode

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
 */
class Solution {

  private var distance = 0
  private var result = 0

  private fun TreeNode.isLeaf(): Boolean = this.left == null && this.right == null

  /**
   * @return an array indicates how many leaf in different distance, because we only care about <= distance leaf, create an array for that
   *
   *  0 1 2 3 4
   * [0 2 0 1 0] means there is 2 leaf that is 1 distance away and 1 leaf that is 3 distance away
   * in total we only care about distance <= 4, so create array with size = distance + 1 should be enough
   *
   * For each subtree, we shall get both tree from both left and right subtree, before calculating array of current node
   */
  private fun dfs(root: TreeNode?): IntArray {
    val r = IntArray(this.distance + 1)
    if (null == root) return r

    // leaf node
    if (root.isLeaf()) {
      r[1] = 1
      return r
    }

    val left = this.dfs(root.left)
    val right = this.dfs(root.right)

    // add to result for those matching combination
    for (i in 1 until distance) {
      for (j in 1 until distance) {
        if (i + j <= distance) {
          // calculation combination
          this.result += left[i] * right[j]
        }
      }
    }

    // prepare for parent level
    for (i in 1..distance) {
      // for parent level, increase distance by 1
      r[i] = left[i - 1] + right[i - 1]
    }

    return r
  }

  fun countPairs(root: TreeNode?, distance: Int): Int {
    this.result = 0
    this.distance = distance

    if (null == root) return this.result

    this.dfs(root)

    return this.result
  }
}
