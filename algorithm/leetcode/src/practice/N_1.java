package practice;

import java.util.HashMap;
import java.util.Map;

public class N_1 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i){
            if (hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            hm.put(nums[i], i);
        }
        return new int[0];
    }
}
