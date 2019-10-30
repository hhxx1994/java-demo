package leetcode;

/**
 * @author huanghaoxing
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return preOrder(root);
    }

    private int preOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer height = getHeight(root);
        int left = preOrder(root.left);
        int right = preOrder(root.right);
        return Math.max(Math.max(height, left), right);
    }


    private Integer getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return treeHeight(root.right) + treeHeight(root.left);
        }
        if (root.left != null) {
            return treeHeight(root.left);
        }
        if (root.right != null) {
            return treeHeight(root.right);
        }
        return 0;
    }

    /**
     * 树高
     *
     * @param node
     * @return
     */
    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeHeight(node.left) + 1;
        int right = treeHeight(node.right) + 1;
        return Math.max(left, right);
    }
}
