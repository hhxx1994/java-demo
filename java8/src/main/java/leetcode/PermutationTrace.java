package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class PermutationTrace {
    public List<List<Integer>> permutationTrace(int[] nums) {
        List<Integer> trace = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permutationTrace(nums, trace, result);
        return result;
    }

    private void permutationTrace(int[] nums, List<Integer> trace, List<List<Integer>> result) {
        if (trace.size() == nums.length) {
            result.add(new ArrayList<>(trace));
            return;
        }
        for (int num : nums) {
            if (trace.contains(num)) {
                continue;
            }
            trace.add(num);
            permutationTrace(nums, trace, result);
            trace.remove(trace.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationTrace permutation = new PermutationTrace();
        System.out.println(permutation.permutationTrace(new int[]{1, 2, 3}));
    }
}
