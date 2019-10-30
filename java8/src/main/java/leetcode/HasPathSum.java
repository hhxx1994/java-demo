package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huanghaoxing
 * 112. 路径总和
 */
public class HasPathSum {
    boolean ret = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        paths(root, sum, 0);
        return ret;
    }

    /**
     * 深度优先遍历
     *
     * @param treeNode
     * @param sum
     * @param csum
     */
    public void paths(TreeNode treeNode, int sum, int csum) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            if (sum == csum + treeNode.val) {
                ret = true;
            }
        } else {
            paths(treeNode.left, sum, csum + treeNode.val);
            paths(treeNode.right, sum, csum + treeNode.val);
        }
    }

    /**
     * bsf
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, root.val));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.treeNode.right == null && node.treeNode.left == null) {
                if (node.sum == sum) {
                    return true;
                }
            }
            if (node.treeNode.left != null) {
                queue.add(new Node(node.treeNode.left, node.sum + node.treeNode.left.val));
            }
            if (node.treeNode.right != null) {
                queue.add(new Node(node.treeNode.right, node.sum + node.treeNode.right.val));
            }
        }
        return false;
    }


    static class Node {
        TreeNode treeNode;
        int sum;

        public Node(TreeNode treeNode, int sum) {
            this.treeNode = treeNode;
            this.sum = sum;
        }
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> integers = new LinkedList<>();
        queue.add(root);
        integers.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer num = integers.poll();
            if (node.right == null && node.left == null) {
                if (sum == node.val + num) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.add(node.left);
                integers.add(num + node.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                integers.add(num + node.val);
            }
        }
        return false;
    }


}
