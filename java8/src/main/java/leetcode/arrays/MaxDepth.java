package leetcode.arrays;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class MaxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        int max = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            Integer height = pair.getValue();
            max = Math.max(height, max);
            if (treeNode.right != null) {
                queue.add(new Pair<>(treeNode.right, height + 1));
            }
            if (treeNode.left != null) {
                queue.add(new Pair<>(treeNode.left, height + 1));
            }
        }
        return max;

    }
}
