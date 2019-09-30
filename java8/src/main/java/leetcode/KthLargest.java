package leetcode;

import java.util.PriorityQueue;

/**
 * @author huanghaoxing
 */
public class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
            return priorityQueue.peek();
        }

        if (val > priorityQueue.peek()) {
            priorityQueue.add(val);
        }
        return priorityQueue.peek();
    }
}
