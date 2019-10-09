package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huanghaoxing
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));
        while (!stack.isEmpty()) {
            Pair<TreeNode, String> pair = stack.pop();
            TreeNode treeNode = pair.getKey();
            String path = pair.getValue();
            if (treeNode.right != null) {
                stack.push(new Pair<>(treeNode.right, path + "->" + treeNode.right.val));
            }
            if (treeNode.left != null) {
                stack.push(new Pair<>(treeNode.left, path + "->" + treeNode.left.val));
            }
            if (treeNode.left == null && treeNode.right == null) {
                list.add(path);
            }
        }
        return list;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        build(root, String.valueOf(root.val), paths);
        return paths;
    }

    public void build(TreeNode treeNode, String path, List<String> paths) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.right == null && treeNode.left == null) {
            paths.add(path);
        }
        if (treeNode.left != null) {
            build(treeNode.left, path + "->" + treeNode.left.val, paths);
        }
        if (treeNode.right != null) {
            build(treeNode.right, path + "->" + treeNode.right.val, paths);
        }
    }
}
