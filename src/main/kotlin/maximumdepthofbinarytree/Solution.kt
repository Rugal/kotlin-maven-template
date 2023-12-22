package maximumdepthofbinarytree

import kotlin.math.max
import countgoodnodesinbinarytree.TreeNode

class Solution {
  fun maxDepth(root: TreeNode?): Int =
    if (null == root) 0 else max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1
}
