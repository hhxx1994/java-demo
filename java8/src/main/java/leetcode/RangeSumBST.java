package leetcode;

import java.util.Stack;

/**
 * @author huanghaoxing
 */
public class RangeSumBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (true) {
            while (root != null) {
                // visit
                if (L <= root.val && root.val <= R) {
                    sum += root.val;
                }
                stack.push(root.right);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
        }
        return sum;
    }
}
