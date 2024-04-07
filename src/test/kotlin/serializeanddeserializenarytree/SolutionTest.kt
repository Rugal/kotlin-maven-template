package serializeanddeserializenarytree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
  val s = Solution()
  private val root = DirectedGraphNode(1).also {
    it.neighbors.add(DirectedGraphNode(2).also {
      it.neighbors.add(DirectedGraphNode(5))
    })
    it.neighbors.add(DirectedGraphNode(3))
    it.neighbors.add(DirectedGraphNode(4).also {
      it.neighbors.add(DirectedGraphNode(6).also {
        it.neighbors.add(DirectedGraphNode(9))
        it.neighbors.add(DirectedGraphNode(10))
        it.neighbors.add(DirectedGraphNode(11))
      })
      it.neighbors.add(DirectedGraphNode(7))
    })
    it.neighbors.add(DirectedGraphNode(8))
  }

  //  @Disabled
  @Test
  fun serialize() {
    println(s.serialize(root))
  }

  //  @Disabled
  @Test
  fun deserialize() {
    val origin = this.s.serialize(root)
    val copy = this.s.deserialize(origin)

    Assertions.assertEquals(origin, this.s.serialize(copy))
    println(this.s.serialize(copy))
  }
}
