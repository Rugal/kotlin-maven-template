package serializeanddeserializebinarytree

import countgoodnodesinbinarytree.TreeNode
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class CodecTest {

  private val s = Codec()

  // 1[2[4[[] []] []] 3[[] 4[[] []]]]
  private val root1 = TreeNode(1).also {
    it.left = TreeNode(2).also {
      it.left = TreeNode(4)
    }
    it.right = TreeNode(3)
      .also {
        it.right = TreeNode(4)
      }
  }

  private val root2 = TreeNode(1)

  @Disabled
  @Test
  fun serialize() {
    println(this.s.serialize(root1))
    println(this.s.serialize(root2))
  }

  @Test
  fun deserialize() {
    val data = this.s.serialize(root1)
    println(data)
    Assertions.assertEquals(data, this.s.serialize(this.s.deserialize(data)))
  }
}
