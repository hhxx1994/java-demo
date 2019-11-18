package leetcode;

/**
 * @author huanghaoxing
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        int count = 0;
        while (i > 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }
}
