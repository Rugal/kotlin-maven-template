package twosumbsts

import countgoodnodesinbinarytree.TreeNode
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun twoSumBSTs() {
    val r1 = TreeNode(2).also {
      it.left = TreeNode(1)
      it.right = TreeNode(1)
    }

    val r2 = TreeNode(1).also {
      it.left = TreeNode(0)
      it.right = TreeNode(3)
    }

    this.s.twoSumBSTs(r1, r2, 5)
  }
}
