package leetcode;

import java.util.Objects;

/**
 * @author huanghaoxing
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {

    int xHeight;
    TreeNode xParent;
    int yHeight;
    TreeNode yParent;


    public boolean isCousins(TreeNode root, int x, int y) {
        height(root, root, 0, x, y);
        if (xHeight == yHeight && !Objects.equals(xParent, yParent)) {
            return true;
        }
        return false;
    }

    public void height(TreeNode treeNode, TreeNode parent, int height, int x, int y) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val == x) {
            xHeight = height;
            xParent = parent;
        }
        if (treeNode.val == y) {
            yHeight = height;
            yParent = parent;
        }
        height(treeNode.left, treeNode, height + 1, x, y);
        height(treeNode.right, treeNode, height + 1, x, y);
    }
}
