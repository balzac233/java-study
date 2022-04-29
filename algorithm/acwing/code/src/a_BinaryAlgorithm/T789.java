package a_BinaryAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @problem 789数的范围
 * @idea 二分法查找
 */
public class T789 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final Scanner sc =new Scanner(System.in);
    public static int n, q;
    public static void main(String[] args) throws Exception{
        n = sc.nextInt();
        q = sc.nextInt();
        int k;
        int[] arr = new int[n];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        for (int i = 0; i < q; i++) {
            k = sc.nextInt();
            startToEnd(arr, k);
        }
    }

    public static void startToEnd(int[] arr, int k){
        int l = 0, r = n - 1;
        while (l < r){
            int mid = (l + r) / 2;
            if (arr[mid] >= k) r = mid;
            else l = mid + 1;
        }
        if(arr[l] != k) System.out.println("-1 -1");
        else {
            System.out.println(l + " ");
            l = 0;
            r = n - 1;
            while (l < r){
                int mid = (l + r + 1) / 2;
                if(arr[mid] <= k) l = mid;
                else r = mid - 1;
            }
            System.out.println(l);
        }
    }
}
