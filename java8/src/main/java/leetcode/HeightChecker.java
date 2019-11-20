package leetcode;

/**
 * @author huanghaoxing
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] bucket = new int[101];
        for (int height : heights) {
            bucket[height]++;
        }
        int ret = 0;
        int index = 0;
        for (int i = 0, length = bucket.length; i < length; i++) {
            while (bucket[i] > 0) {
                if (i != heights[index++]) {
                    ret++;
                }
                bucket[i]--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }


}
