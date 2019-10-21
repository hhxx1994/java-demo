package leetcode;

/**
 * @author huanghaoxing
 */
public class FindNode {
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return find(root.right, val);
        } else {
            return find(root.left, val);
        }
    }
}
