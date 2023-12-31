package largestbstsubtree

import countgoodnodesinbinarytree.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {

  private val s = Solution()

  @Test
  fun largestBSTSubtree_1() {
    val root = TreeNode(10).also {
      it.left = TreeNode(5).also {
        it.left = TreeNode(1)
        it.right = TreeNode(8)
      }
      it.right = TreeNode(15).also {
        it.right = TreeNode(7)
      }
    }
    Assertions.assertEquals(3, s.largestBSTSubtree(root))
  }

  @Test
  fun largestBSTSubtree_2() {
    // [3,2,4,null,null,1]
    val root = TreeNode(2).also {
      it.left = TreeNode(2).also {
        it.left = TreeNode(1)
      }
    }

    Assertions.assertEquals(2, s.largestBSTSubtree(root))
  }

  @Test
  fun largestBSTSubtree_3() {
    // [3,2,4,null,null,1]
    val root = TreeNode(3).also {
      it.left = TreeNode(2)
      it.right = TreeNode(4).also {
        it.left = TreeNode(1)
      }
    }

    Assertions.assertEquals(2, s.largestBSTSubtree(root))
  }
}
