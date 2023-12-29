package convertsortedarraytobinarysearchtree

import countgoodnodesinbinarytree.TreeNode

class Solution {
  private fun dc(nums: IntArray, begin: Int, end: Int): TreeNode? {
    if (begin > end) return null
    val mid = (begin + end) / 2

    return TreeNode(nums[mid]).also {
      it.left = this.dc(nums, begin, mid - 1)
      it.right = this.dc(nums, mid + 1, end)
    }
  }

  fun sortedArrayToBST(nums: IntArray): TreeNode? = this.dc(nums, 0, nums.size - 1)
}
