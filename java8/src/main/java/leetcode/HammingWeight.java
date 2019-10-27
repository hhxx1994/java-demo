package leetcode;

/**
 * @author huanghaoxing
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return 0;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
