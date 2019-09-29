package leetcode.arrays;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 */
public class MinDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left) + 1, minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right) + 1, minDepth);
        }
        return minDepth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        Integer height = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode treeNode = pair.getKey();
            height = pair.getValue();
            if (treeNode.left == null && treeNode.right == null) {
                break;
            }
            if (treeNode.left != null) {
                queue.add(new Pair<>(treeNode.left, height + 1));
            }
            if (treeNode.right != null) {
                queue.add(new Pair<>(treeNode.right, height + 1));
            }
        }
        return height;
    }
}
