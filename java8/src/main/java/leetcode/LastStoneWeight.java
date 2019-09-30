package leetcode;

import java.util.PriorityQueue;

/**
 * @author huanghaoxing
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() >= 2) {
            Integer top = queue.poll();
            Integer top2 = queue.poll();
            int i = top - top2;
            if (i != 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1});
    }
}
