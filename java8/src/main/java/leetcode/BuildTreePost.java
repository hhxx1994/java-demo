package leetcode;


/**
 * @author huanghaoxing
 */
public class BuildTreePost {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (pStart == pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int num = rootIndex - iStart;
        root.left = buildTree(inorder, iStart, iStart + num, postorder, pStart, pStart + num);
        root.right = buildTree(inorder, iStart + num + 1, iEnd, postorder, pStart + num, pEnd - 1);
        return root;
    }

}
