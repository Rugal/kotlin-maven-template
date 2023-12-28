package allelementsintwobinarysearchtrees

import countgoodnodesinbinarytree.TreeNode
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @BeforeEach
  fun setUp() {
  }

  @Test
  fun getAllElementsIterative() {
    val root = TreeNode(4).also {
      it.left = TreeNode(2).also {
        it.left = TreeNode(1)
        it.right = TreeNode(3)
      }
      it.right = TreeNode(6).also {
        it.left = TreeNode(5)
        it.right = TreeNode(7)
      }
    }
    this.s.getAllElementsIterative(root, null)
  }
}
