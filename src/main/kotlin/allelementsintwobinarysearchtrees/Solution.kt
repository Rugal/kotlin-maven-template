package allelementsintwobinarysearchtrees

import java.util.Stack
import countgoodnodesinbinarytree.TreeNode

class Solution {
  private val result = mutableListOf<Int>()

  private fun dfs(root: TreeNode?) {
    if (null == root) return
    this.dfs(root.left)
    this.result.add(root.`val`)
    this.dfs(root.right)
  }

  fun getAllElementsRecursive(root1: TreeNode?, root2: TreeNode?): List<Int> {
    this.result.clear()
    this.dfs(root1)
    this.dfs(root2)
    return this.result.sorted()
  }

  fun getAllElementsIterative(root1: TreeNode?, root2: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    var root1 = root1
    var root2 = root2
    val stack1 = Stack<TreeNode>()
    val stack2 = Stack<TreeNode>()

    while (null != root1 || stack1.isNotEmpty()
      || null != root2 || stack2.isNotEmpty()
    ) {
      while (null != root1) {
        stack1.push(root1)
        root1 = root1.left
      }
      while (null != root2) {
        stack2.push(root2)
        root2 = root2.left
      }

      // at least one of the stack must not be empty at this step
      if (stack2.isEmpty()
        || stack1.isNotEmpty() && stack1.peek().`val` <= stack2.peek().`val`
      ) {
        root1 = stack1.pop()
        result.add(root1.`val`)
        root1 = root1.right
      } else {
        root2 = stack2.pop()
        result.add(root2.`val`)
        root2 = root2.right
      }
    }

    return result
  }
}
