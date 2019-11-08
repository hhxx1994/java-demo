package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public TreeNode buildTree2(Integer[] arrs) {
        return tree(0, arrs);
    }

    public TreeNode tree(int index, Integer[] arrs) {
        if (index >= arrs.length) {
            return null;
        }
        TreeNode node = new TreeNode(arrs[index]);
        TreeNode left = tree(index << 1 | 1, arrs);
        TreeNode right = tree((index + 1) << 1, arrs);
        node.left = left;
        node.right = right;
        return node;
    }

    public List<Integer> travel(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Array2Tree array2Tree = new Array2Tree();
        TreeNode treeNode = array2Tree.buildTree2(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(array2Tree.travel(treeNode));
    }


}
