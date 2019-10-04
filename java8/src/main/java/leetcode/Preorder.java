package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author huanghaoxing
 */
public class Preorder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (!root.children.isEmpty()) {
            for (Node child : root.children) {
                preorder(child, list);
            }
        }
    }


    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                list.add(root.val);
                if (!root.children.isEmpty()) {
                    for (int i = root.children.size() - 1; i > 0; i--) {
                        stack.push(root.children.get(i));
                    }
                    root = root.children.get(0);
                } else {
                    root = null;
                }
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
        }
        return list;
    }

    public List<Integer> preorder3(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            if (!node.children.isEmpty()) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return list;
    }
}
