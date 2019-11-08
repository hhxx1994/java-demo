package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Array2Tree {


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
                if (index >= arrs.length) {
                    break;
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

    /**
     * 递归去构造一棵树
     *
     * @param arrs
     * @return
     */

    public TreeNode buildTree2(int[] arrs) {
        return tree(0, arrs);
    }

    public TreeNode tree(int index, int[] arrs) {
        if (index >= arrs.length) {
            return null;
        }
        TreeNode node = new TreeNode(arrs[index]);
        TreeNode left = tree(index << 1 | 1, arrs);
        TreeNode right = tree(index << 2, arrs);
        node.left = left;
        node.right = right;
        return node;
    }


}
