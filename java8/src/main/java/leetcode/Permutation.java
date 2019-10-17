package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Permutation {

    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutation(nums, 0, list);
        return list;
    }

    private void permutation(int[] nums, int index, List<List<Integer>> list) {
        if (nums.length - 1 == index) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            list.add(result);
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permutation(nums, index + 1, list);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permutation(new int[]{1, 2, 3}));
    }


}
