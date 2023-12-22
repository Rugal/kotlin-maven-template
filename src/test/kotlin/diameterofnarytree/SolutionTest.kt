package diameterofnarytree

import kotlin.test.Test
import org.junit.jupiter.api.Assertions

class SolutionTest {

  private val s = Solution()

  @Test
  fun test1() {
    val tree = UndirectedGraphNode(1)

    Assertions.assertEquals(0, this.s.diameter(tree))
  }

  @Test
  fun test2() {
    val tree = UndirectedGraphNode(1)
    tree.neighbors.add(UndirectedGraphNode(2))
    tree.neighbors.add(UndirectedGraphNode(3))
    tree.neighbors.add(UndirectedGraphNode(4))

    Assertions.assertEquals(2, this.s.diameter(tree))
  }

  @Test
  fun test3() {
    val tree = UndirectedGraphNode(1)
    tree.neighbors.add(UndirectedGraphNode(2))
    tree.neighbors.add(UndirectedGraphNode(3))
    tree.neighbors.add(UndirectedGraphNode(4))

    tree.neighbors[0].neighbors.add(UndirectedGraphNode(5))

    Assertions.assertEquals(3, this.s.diameter(tree))
  }

  /*
         1
       2
     3  4
    5    6
*/
  @Test
  fun test4() {
    val tree = UndirectedGraphNode(1).also {
      it.neighbors.add(UndirectedGraphNode(2).also {
        it.neighbors.add(UndirectedGraphNode(3).also {
          it.neighbors.add(UndirectedGraphNode(5))
        })
        it.neighbors.add(UndirectedGraphNode(4).also {
          it.neighbors.add(UndirectedGraphNode(6))
        })
      })
    }

    Assertions.assertEquals(4, this.s.diameter(tree))
  }

  /*
           1
      2    3    4
           5    6
  */
  @Test
  fun test5() {
    val tree = UndirectedGraphNode(1).also {
      it.neighbors.add(UndirectedGraphNode(2))
      it.neighbors.add(UndirectedGraphNode(3).also {
        it.neighbors.add(UndirectedGraphNode(5))
      })
      it.neighbors.add(UndirectedGraphNode(4).also {
        it.neighbors.add(UndirectedGraphNode(6))
      })
    }

    Assertions.assertEquals(4, this.s.diameter(tree))
  }
}
