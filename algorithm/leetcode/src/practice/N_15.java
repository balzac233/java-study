package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) return ans;
        int target;
        int left, right;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = -nums[i];
            left = i + 1;
            right = n - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if( sum== target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    ++left;
                    --right;
                    while (left < right && nums[left] == nums[left - 1]) ++left;
                    while (left < right && nums[right] == nums[right - 1]) --right;
                }else if(sum < target) ++left;
                else --right;

            }
        }
        return ans;
    }
}
