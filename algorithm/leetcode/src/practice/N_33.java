package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @problem 33. 搜索旋转排序数组
 * @idea 二分法
 */
public class N_33 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(",");
        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int target = new Scanner(System.in).nextInt();
        br.close();
        int index = search(nums, target);
        System.out.println(index);
    }

    /**
     * O(logn) + O(1)
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == target ? 0 : -1;
        int l = 0, r = len - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[0])
                if(target >= nums[0] && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            else
                if(target > nums[mid] && target <= nums[len - 1]) l = mid + 1;
                else r = mid - 1;
        }
        return -1;
    }

}
