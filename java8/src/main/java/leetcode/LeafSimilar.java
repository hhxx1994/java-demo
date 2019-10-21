package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1 = new ArrayList<>();
        List<Integer> tree2 = new ArrayList<>();
        getLeaves(root1, tree1);
        getLeaves(root2, tree2);

        return tree1.equals(tree2);
    }

    private void getLeaves(TreeNode treeNode, List<Integer> leaves) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.right == null && treeNode.left == null) {
            leaves.add(treeNode.val);
        }
        getLeaves(treeNode.left, leaves);
        getLeaves(treeNode.right, leaves);
    }
}
