package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }

            map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum T = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        T.twoSum(nums, target);
    }
}
