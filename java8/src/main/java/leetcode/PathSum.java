package leetcode;

/**
 * @author huanghaoxing
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return paths(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
    }

    private int paths(TreeNode treeNode, int sum) {
        if (treeNode == null) {
            return 0;
        }
        int ret = 0;
        if (treeNode.val == sum) {
            ret++;
        }
        ret += paths(treeNode.left, sum - treeNode.val);
        ret += paths(treeNode.right, sum - treeNode.val);
        return ret;
    }
}
