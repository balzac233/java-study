package practice;

public class N_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if(target < nums[mid]) right = mid - 1;
            else if(target > nums[mid]) left = mid + 1;
            else return mid;
        }
        return target <= nums[left] ? left : left + 1;
    }
}
