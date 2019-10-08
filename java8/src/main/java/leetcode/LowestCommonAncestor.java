package leetcode;

/**
 * @author huanghaoxing
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        int pVal = p.val;
        int qVal = q.val;
        while (root != null) {
            int val = root.val;
            if (pVal < val && qVal < val) {
                root = root.left;
            } else if (val < pVal && val < qVal) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
