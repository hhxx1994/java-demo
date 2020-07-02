package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huanghaoxing
 */
public class Rob {

  int ret;
  Map<Integer,Integer> map = new HashMap<>();
  public int rob(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];
    choose(nums, nums.length - 1);
    choose(nums, nums.length - 2);
    return ret;
  }

  private int choose(int[] nums, int i) {
    if(map.containsKey(i)){
      return map.get(i) ;
    }
    if (i < 0 || i - 2 < 0) {
      return nums[i];
    }
    if (i - 2 == 0) {
      return nums[i-2];
    }

    int ret = Math.max(choose(nums, i - 2  ), choose(nums, i - 3));
    map.put(i,ret);
    return  ret;
  }

  public static void main(String[] args) {
    Rob rob = new Rob();
    System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1,3,4,5}));
  }
}
