package lowestcommonancestorofabinarytreeiv;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  private TreeNode result = null;

  private int dfs(TreeNode root, Set<Integer> values) {
    if (null == root) return 0;

    final var left = this.dfs(root.left, values);
    final var right = this.dfs(root.right, values);
    final var current = values.contains(root.val) ? 1 : 0;

    final var r = left + right + current;
    // if root contains all values and is the first time seeing this phenomenon
    // it must be the LCA of all
    if (values.size() == r && this.result == null) {
      this.result = root;
    }

    return r;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    final var set = Arrays.stream(nodes)
      .map(it -> it.val)
      .collect(Collectors.toSet());

    this.dfs(root, set);

    return this.result;
  }
}
