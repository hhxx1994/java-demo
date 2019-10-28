package leetcode;

/**
 * @author huanghaoxing
 * 783. 二叉搜索树结点最小距离
 */
public class MinDiffInBST {
    int res = Integer.MAX_VALUE;
    TreeNode pre;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        if (pre != null) {
            res = Math.min(res, treeNode.val - pre.val);
        }
        pre = treeNode;
        inOrder(treeNode.right);
    }


}
