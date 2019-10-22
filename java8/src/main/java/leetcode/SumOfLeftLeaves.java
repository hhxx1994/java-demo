package leetcode;

/**
 * @author huanghaoxing
 */
public class SumOfLeftLeaves {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);

        }
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        return 0;
    }

    public int sum(TreeNode treeNode, TreeNode parentNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null && parentNode.left == treeNode) {
            return treeNode.val;
        }
        return sum(treeNode.left, treeNode) + sum(treeNode.right, treeNode);
    }

}
