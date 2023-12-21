package pathsumiii

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private val cache = mutableMapOf<Long, Int>()
  private var result = 0
  private var target = 0

  private fun backtrack(root: TreeNode?, sum: Long) {
    if (null == root) return

    val current = sum + root.`val`

    /*      
      1
        2
          3
            4
              5
      4..5 == 1..5 - 1..3
      sub path  ==  full path - prefix
      当前路径减去前缀 就是中间一段，如果能够找到，说明中间这一段的和就等于sum，因此需要加上前缀的个数
     */
    this.result += this.cache.getOrDefault(current - target, 0)
    // setup backtrack
    this.cache[current] = this.cache.getOrDefault(current, 0) + 1
    // start backtrack 
    this.backtrack(root.left, current)
    this.backtrack(root.right, current)
    // reverse backtrack
    this.cache[current] = this.cache[current]!! - 1
  }

  fun pathSum(root: TreeNode?, targetSum: Int): Int {
    this.result = 0
    this.target = targetSum
    this.cache.clear()
    this.cache[0] = 1 // in case of value right match

    this.backtrack(root, 0)

    return this.result
  }
}
