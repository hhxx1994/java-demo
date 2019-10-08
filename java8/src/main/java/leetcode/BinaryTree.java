package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    // 二叉树节点
    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode(int value, BinaryTreeNode left,
                              BinaryTreeNode right) {
            super();
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    // 访问树的节点
    public static void visit(BinaryTreeNode node) {
        System.out.println(node.value);
    }

    /**
     * 递归实现二叉树的先序遍历
     */
    public static void preOrder(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    /**
     * 递归实现二叉树的中序遍历
     */
    public static void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    /**
     * 递归实现二叉树的后序遍历
     */
    public static void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            visit(node);
        }
    }

    /**
     * 非递归实现二叉树的先序遍历
     */
    public static void iterativePreorder(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(node, stack);
            if (stack.isEmpty()) {
                break;
            }
            node = stack.pop();
        }

    }

    public static void iterativePreorder2(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (node != null) {
            stack.push(node);
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    private static void visitAlongLeftBranch(BinaryTreeNode node, Stack<BinaryTreeNode> stack) {
        while (node != null) {
            visit(node);
            stack.push(node.right);
            node = node.left;
        }
    }

    private static void goAlongLeftBranch(BinaryTreeNode node, Stack<BinaryTreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * 非递归实现二叉树的中序遍历
     */
    public static void iterativeInOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(root, stack);
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            visit(root);
            root = root.right;
        }

    }


    /**
     * 非递归使用单栈实现二叉树后序遍历
     */
    public static void iterativePostOrder(BinaryTreeNode root) {

    }

    /**
     * 非递归使用双栈实现二叉树后序遍历
     */
    public static void iterativePostOrderByTwoStacks(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> temp = new Stack<>();
        temp.push(root);
        while (!temp.isEmpty()) {
            BinaryTreeNode treeNode = temp.pop();
            stack.push(treeNode);
            if (treeNode.left != null) {
                temp.push(treeNode.left);
            }
            if (treeNode.right != null) {
                temp.push(treeNode.right);
            }
        }
        while (!stack.isEmpty()) {
            visit(stack.pop());
        }

    }

    /**
     * 二叉树广度优先遍历——层序遍历
     */
    public static void layerTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            visit(root);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

    public static void layerTraversal2(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode treeNode = queue.poll();
                visit(treeNode);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {

        // 构造二叉树
        //                      1
        //                     / \
        //                    2  3
        //                   / / \
        //                  4 5   7
        //                    \  /
        //                    6 8
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node7;
        node5.right = node6;
        node7.left = node8;
        System.out.println("二叉树先序遍历");
        preOrder(root);
        System.out.println("二叉树先序遍历非递归");
        iterativePreorder(root);
        System.out.println("二叉树先序遍历非递归2");
        iterativePreorder2(root);
        System.out.println("二叉树中序遍历");
        inOrder(root);
        System.out.println("二叉树中序遍历非递归");
        iterativeInOrder(root);
        System.out.println("二叉树后序遍历");
        postOrder(root);
        System.out.println("二叉树单栈非递归后序遍历");
        iterativePostOrder(root);
        System.out.println("二叉树双栈非递归后序遍历");
        iterativePostOrderByTwoStacks(root);
        System.out.println("二叉树层树序遍历");
        layerTraversal(root);
        System.out.println("二叉树层树序遍历");
        layerTraversal2(root);

    }
}