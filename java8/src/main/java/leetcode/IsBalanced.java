package leetcode;

/**
 * @author huanghaoxing
 * 110. 平衡二叉树
 */
public class IsBalanced {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isBalanced;
    }

    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = 1 + height(treeNode.left);
        int right = 1 + height(treeNode.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
            return 0;
        }
        return Math.max(left, right);
    }
}
