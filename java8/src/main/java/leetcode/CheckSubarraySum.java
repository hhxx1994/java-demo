package leetcode;

/**
 * @author huanghaoxing
 */
public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += nums[i];
                }
                if (k != 0 && sum % k == 0) {
                    return true;
                }
                if (k == 0 && sum == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int result = sum[end] - sum[start] + nums[start];
                if (k != 0 && result % k == 0) {
                    return true;
                }
                if (k == 0 && result == 0) {
                    return true;
                }
            }
        }
        return false;
    }


}
