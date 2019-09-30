package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, preorder.length, inorderMap);
    }

    public TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> inorderMap) {
        if (pStart >= pEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        Integer iRootIndex = inorderMap.get(rootVal);
        int num = iRootIndex - iStart;
        root.left = buildTree(preorder, pStart + 1, pStart + 1 + num, inorder, iStart, iRootIndex, inorderMap);
        root.right = buildTree(preorder, pStart + 1 + num, pEnd, inorder, iRootIndex + 1, iEnd, inorderMap);
        return root;
    }


}
