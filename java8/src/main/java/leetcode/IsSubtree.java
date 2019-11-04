package leetcode;

/**
 * @author huanghaoxing
 * 572. 另一个树的子树
 */
public class IsSubtree {
    boolean ret = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        findNode(s, t);
        return ret;
    }

    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    private void findNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root.val == node.val) {
            if (isSameTree(root, node)) {
                ret = true;
                return;
            }
        }

        findNode(root.right, node);
        findNode(root.left, node);
    }
}
