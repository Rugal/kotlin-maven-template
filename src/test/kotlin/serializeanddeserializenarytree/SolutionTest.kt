package serializeanddeserializenarytree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SolutionTest {
  val s = Solution()
  private val root = RugalDirectedGraphNode(1).also {
    it.neighbors.add(RugalDirectedGraphNode(2).also {
      it.neighbors.add(RugalDirectedGraphNode(5))
    })
    it.neighbors.add(RugalDirectedGraphNode(3))
    it.neighbors.add(RugalDirectedGraphNode(4).also {
      it.neighbors.add(RugalDirectedGraphNode(6).also {
        it.neighbors.add(RugalDirectedGraphNode(9))
        it.neighbors.add(RugalDirectedGraphNode(10))
        it.neighbors.add(RugalDirectedGraphNode(11))
      })
      it.neighbors.add(RugalDirectedGraphNode(7))
    })
    it.neighbors.add(RugalDirectedGraphNode(8))
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
