package leetcode;

/**
 * @author huanghaoxing
 * 687. 最长同值路径
 */
public class LongestUnivaluePath {
    int ret = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth(root,root);
        return ret;
    }

    private int depth(TreeNode node, TreeNode parent) {
        if (node == null || parent == null) {
            return 0;
        }
        int left = depth(node.left, node);
        int right = depth(node.right, node);
        ret = Math.max(ret, left + right);
        if (node.val == parent.val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
