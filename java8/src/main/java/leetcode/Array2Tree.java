package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Array2Tree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(Integer[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(arrs[index++]);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (index < arrs.length) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode treeNode : list) {
                Integer left = arrs[index++];
                if (left != null) {
                    treeNode.left = new TreeNode(left);
                    temp.add(treeNode.left);
                }
                Integer right = arrs[index++];
                if (right != null) {
                    treeNode.right = new TreeNode(right);
                    temp.add(treeNode.right);
                }
            }
            list = temp;
        }
        return root;
    }

}
