package findleavesofbinarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionJava {

  private final Graphql g = new Graphql();

  private void dfs(TreeNode root) {
    if (null == root) {
      return;
    }
    if (null == root.left && null == root.right) {
      this.g.inDegree.put(root, 0);
      this.g.adjacency.putIfAbsent(root, new LinkedList<>());
      return;
    }

    // add adjacency if has child
    if (null != root.left) {
      this.g.add(root.left, root);
    }
    if (null != root.right) {
      this.g.add(root.right, root);
    }

    // recurse to children
    this.dfs(root.left);
    this.dfs(root.right);
  }

  /*
   * @param root: the root of binary tree
   * @return: collect and remove all leaves
   */
  public List<List<Integer>> findLeaves(TreeNode root) {
    final List<List<Integer>> result = new ArrayList<>();

    if (null == root) {
      return result;
    }
    // write your code here
    this.g.clear();
    this.dfs(root);

    var a = this.g.inDegree
      .entrySet()
      .stream()
      .filter(it -> it.getValue() == 0)
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());
    var queue = new LinkedList<>(a);

    while (!queue.isEmpty()) {
      final var size = queue.size();
      var list = new LinkedList<Integer>();
      for (int i = 0; i < size; ++i) {
        TreeNode current = queue.poll();
        list.add(current.val);

        this.g.adjacency.get(current).forEach(it -> {
          this.g.inDegree.put(it, this.g.inDegree.get(it) - 1);
          if (0 == this.g.inDegree.get(it)) {
            queue.offer(it);
          }
        });
      }

      result.add(list);
    }

    return result;
  }
}

class Graphql {
  final Map<TreeNode, Integer> inDegree = new HashMap<>();
  final Map<TreeNode, List<TreeNode>> adjacency = new HashMap<>();

  public void clear() {
    this.inDegree.clear();
    this.adjacency.clear();
  }

  public void add(TreeNode from, TreeNode to) {
    /*
     * inDegree
     */
    this.inDegree.putIfAbsent(from, 0);

    this.inDegree.putIfAbsent(to, 0);
    this.inDegree.put(to, this.inDegree.get(to) + 1);
    /*
     * adjacency
     */
    this.adjacency.putIfAbsent(from, new LinkedList<>());
    this.adjacency.get(from).add(to);

    this.adjacency.putIfAbsent(to, new LinkedList<>());
  }
}

class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
    this.left = this.right = null;
  }
}
