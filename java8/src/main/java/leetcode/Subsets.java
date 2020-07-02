package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class Subsets {
  List<List<Integer>> ret = new ArrayList<>();
  public List<List<Integer>> subsets(int[] nums) {
    for(int i = 0 ; i <= nums.length; i++){
      backtrack(nums,i,new ArrayList<>(),0);
    }
    return ret;

  }

  private void backtrack(int[] nums , int length , List<Integer> temp ,int start){
    if(temp.size() == length){
      ret.add(new ArrayList(temp));
      return;
    }

    for(int i = 0; i < nums.length ; i++){
      if(temp.contains(nums[i]))
        continue;
      temp.add(nums[i]);
      backtrack(nums,length,temp,i+1);
      temp.remove(temp.size()-1);
    }
  }

  public static void main(String[] args) {
    Subsets subsets = new Subsets();
    subsets.subsets(new int[]{1,2});

  }
}
