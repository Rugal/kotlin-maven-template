package lowestcommonancestorofabinarytreeii;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii">leetcode</a>
 */
class Solution {
  private TreeNode result = null;

  private int dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (null == root) return 0;

    final var left = this.dfs(root.left, p, q);
    final var right = this.dfs(root.right, p, q);
    final var current = (root == p || root == q) ? 1 : 0; // must match, because p/q is not necessary to exist
    final var r = left + right + current;
    if (2 == r && this.result == null) { // only when both node found
      this.result = root;
    }
    return r;
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    this.dfs(root, p, q);
    return this.result;
  }
}
