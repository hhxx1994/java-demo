package leetcode;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);

    }

    private static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }

        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
    }
}