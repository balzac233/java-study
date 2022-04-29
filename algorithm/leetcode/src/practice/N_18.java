package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_18 {
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 4) return ans;
        int left,right;
        int midTarget;
        int sum;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if((long)nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; ++j){
                if((long)nums[i] + nums[j] + nums[i + 1] + nums[i + 2] > target) break;
                if((long)nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                left = j + 1;
                right = n - 1;
                midTarget = target - nums[i] - nums[j];
                while (left < right){
                    sum = nums[left] + nums[right];
                    if(sum == midTarget){
                        ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        ++left;
                        --right;
                        while (left < right && nums[left] == nums[left - 1]) ++left;
                        while (left < right && nums[right] == nums[right + 1]) --right;
                    }
                    else if(sum < midTarget) ++left;
                    else --right;
                }
            }

        }
        return ans;
    }
}
