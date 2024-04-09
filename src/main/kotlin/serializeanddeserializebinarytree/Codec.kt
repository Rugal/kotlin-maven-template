package serializeanddeserializebinarytree

import countgoodnodesinbinarytree.TreeNode

class Codec {

  /**
   * 1[[] []]
   * 1[2[[] []] []]
   * 1[[] 2[[] 3[]]]
   *
   * 1[2[4[[] []] []] 3[[] 4[[] []]]]
   */
  fun serialize(root: TreeNode?): String =
    if (null == root) "[]"
    else "${root.`val`}[${this.serialize(root.left)} ${this.serialize(root.right)}]"

  // Decodes your encoded data to tree.
  fun deserialize(data: String): TreeNode? {
    if (data == "[]") return null

    val first = data.indexOfFirst { it == '[' }

    return TreeNode(data.substring(0, first).toInt()).also {
      val children = ArrayList<String>(2)
      var start = first + 1
      var bracket = 0
      // 1[2[[] []] []]
      for (i in first + 1 until data.length) {
        // 1[[] []]
        if (data[i] == '[') {
          ++bracket
          continue
        }
        if (data[i] != ']') continue
        // now we hit ]
        --bracket
        if (bracket == -1) break
        if (bracket > 0) continue
        // 1[2[4[[] []] []] 3[[] 4[[] []]]]
        children.add(data.substring(start, i + 1))
        start = i + 2
      }

      it.left = this.deserialize(children[0])
      it.right = this.deserialize(children[1])
    }
  }
}
