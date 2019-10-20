package leetcode;

import java.util.Stack;

/**
 * @author huanghaoxing
 */
public class GetMinimumDifference {
    int cc = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            cc = Math.min(root.val - prev, cc);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return cc;
    }

    public int getMinimumDifference2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Integer prev = null;
        int min = Integer.MAX_VALUE;
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode treeNode = stack.pop();
            if(prev != null){
                min = Math.min(treeNode.val - prev, min);
            }
            prev = treeNode.val;
            root = treeNode.right;
        }
        return min;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(5);
        root.right = right;
        TreeNode left = new TreeNode(3);
        right.left = left;
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        System.out.println(getMinimumDifference.getMinimumDifference2(root));
    }
}
