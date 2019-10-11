package leetcode;

/**
 * @author huanghaoxing
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {

            if (root.right == null && root.left == null) {
                // 没有孩子节点
                return null;
            }

            if (root.right != null && root.left != null) {
                // 存在左右孩子节点
                TreeNode min = getMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
                return root;
            }

            {
                // 只有左右孩子其中一个
                if (root.right != null) {
                    return root.right;
                } else {
                    return root.left;
                }
            }
        }
        if (root.val > val) {
            root.left = deleteNode(root.left, val);
        }
        if (root.val < val) {
            root.right = deleteNode(root.right, val);
        }
        return root;
    }

    private TreeNode getMin(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

}
