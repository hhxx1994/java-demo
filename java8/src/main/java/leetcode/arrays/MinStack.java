package leetcode.arrays;

import java.util.Stack;

/**
 * @author huanghaoxing
 */
public class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        data.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            Integer pop = data.pop();
            if (minStack.peek().equals(pop)) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (data.isEmpty()) {
            return -1;
        }
        return data.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
