package leetcode.arrays;

import java.util.Stack;

/**
 * @author huanghaoxing
 */


public class MergeTrees {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t2.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = new TreeNode(t1.val + t2.val);
        s.push(node);
        s1.push(t1);
        s2.push(t2);
        while (!s.isEmpty()) {
            TreeNode treeNode = s.pop();
            t1 = s1.pop();
            t2 = s2.pop();
            if (t1.left == null) {
                treeNode.left = t2.left;
            } else if (t2.left == null) {
                treeNode.left = t1.left;
            } else {
                treeNode.left = new TreeNode(t1.left.val + t2.left.val);
                s.push(treeNode.left);
                s1.push(t1.left);
                s2.push(t2.left);
            }

            if (t1.right == null) {
                treeNode.right = t2.right;
            } else if (t2.right == null) {
                treeNode.right = t1.right;
            } else {
                treeNode.right = new TreeNode(t1.right.val + t2.right.val);
                s.push(treeNode.right);
                s1.push(t1.right);
                s2.push(t2.right);
            }

        }

        return node;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);
        TreeNode t1left = new TreeNode(3);
        t1.left = t1left;
        TreeNode t2 = new TreeNode(2);
        TreeNode t2left = new TreeNode(2);
        t2.left = t2left;
        MergeTrees mergeTrees = new MergeTrees();
        TreeNode node = mergeTrees.mergeTrees2(t1, t2);
    }


}
