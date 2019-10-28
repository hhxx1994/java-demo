package leetcode;

/**
 * @author huanghaoxing
 * 783. 二叉搜索树结点最小距离
 */
public class MinDiffInBST {
    int res = Integer.MIN_VALUE;
    TreeNode pre;

    public int minDiffInBST(TreeNode root) {


        return 0;
    }

    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        if (pre != null) {
            res = Math.max(res, treeNode.val - pre.val);
        }
        pre = treeNode;
        inOrder(treeNode.right);
    }


}
