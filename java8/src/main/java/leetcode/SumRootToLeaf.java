package leetcode;

/**
 * @author huanghaoxing
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf {
    int ret = 0;

    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return ret;
    }

    private void preOrder(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        int next = i << 1 | root.val;
        if (root.right == null && root.left == null) {
            ret += next;
        } else {
            preOrder(root.left, next);
            preOrder(root.right, next);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        TreeNode left2 = new TreeNode(0);
        TreeNode right2 = new TreeNode(1);
        left.left = left2;
        left.right = right2;

        TreeNode left3 = new TreeNode(0);
        TreeNode right3 = new TreeNode(1);
        right.left = left3;
        right.right = right3;
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println(sumRootToLeaf.sumRootToLeaf(root));


    }
}
