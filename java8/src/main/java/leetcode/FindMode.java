package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 * 501. 二叉搜索树中的众数
 */
public class FindMode {

    TreeNode pre = null;
    int currTime = 0;
    int maxTime = 1;
    List<Integer> ret = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        pre = root;
        inOrder(root);
        int[] ints = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ints[i] = ret.get(i);
        }
        return ints;
    }

    private void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        if (pre.val == treeNode.val) {
            currTime++;
        } else {
            currTime = 1;
        }
        if (currTime == maxTime) {
            ret.add(treeNode.val);
        }
        if (currTime > maxTime) {
            ret.clear();
            ret.add(treeNode.val);
            maxTime = currTime;
        }
        pre = treeNode;
        inOrder(treeNode.right);
    }
}
