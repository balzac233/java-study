package b_MergeAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @problem 788逆序对的数量
 * @Idea 归并排序
 */
public class T788 {
    public static int n;
    public static int[] arrTemp = new int[100010];
    public static long rp = 0;
    public static final BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        reversePairs(arr, 0, n - 1);
        System.out.println(rp);
        br.close();
    }

    public static void reversePairs(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            reversePairs(arr, low, mid);
            reversePairs(arr, mid + 1, high);
            for (int i = low; i <= high; i++) {
                arrTemp[i] = arr[i];
            }
            int i = low, j = mid + 1;
            int k = low;
            while (i <= mid && j <=high){
                if (arrTemp[i] <= arrTemp[j]) arr[k++] = arrTemp[i++];
                else {
                    arr[k++] = arrTemp[j++];
                    rp += mid - i + 1;
                }
            }
            while (i <= mid) arr[k++] = arrTemp[i++];
            while (j <= high) arr[k++] = arrTemp[j++];
        }
    }
}
