package serializeanddeserializenarytree

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
class Solution {
  fun serialize(root: RugalDirectedGraphNode?): String =
    if (null == root) ""
    else "${root.label}" + (if (root.neighbors.isNotEmpty()) root.neighbors.joinToString(separator = " ", prefix = "[", postfix = "]", transform = this::serialize) else "[]")

  /**
   * 1[2[5[]] 3[] 4[6[] 7[]]]
   */
  fun deserialize(data: String): RugalDirectedGraphNode {
    // detecting label until [, ] or end of string
    // parse the label
    val firstIndex = data.indexOfFirst { it == '[' }
    val root = RugalDirectedGraphNode(data.substring(0, firstIndex).toInt())
    // detecting neighbors using stack(multiple level), for each element, repeat
    var start = firstIndex + 1
    var bracket = 0
    for (i in firstIndex + 2 until data.length) {
      // if 
      if (data[i] == '[') {
        ++bracket
        continue
      }
      if (data[i] != ']') continue
      // now we hit ]
      // 2[5[]] 397[] 4[6[] 7[]]
      --bracket
      if (bracket == -1) break
      if (bracket > 0) continue
      if (bracket == 0) {
        root.neighbors.add(this.deserialize(data.substring(start, i + 1)))
        start = i + 2
      }
    }
    return root
  }
}

class RugalDirectedGraphNode(x: Int) {
  val label: Int = x
  val neighbors = mutableListOf<RugalDirectedGraphNode>()
}
