package leetcode.arrays;

/**
 * @author huanghaoxing
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int csum = 0;
        int sum = nums[0];
        for (int num : nums) {
            if (csum > 0) {
                csum += num;
            } else {
                csum = num;
            }
            sum = Math.max(sum, csum);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
