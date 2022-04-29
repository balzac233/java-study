package practice.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @problem 1122. 数组的相对排序
 * @idea 由于数组元素范围较小且元素个数较小，采用计数排序
 */
public class N_1122 {
//    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
//        HashMap<Integer, Integer> hs = new HashMap<>();
//        for (int num : arr1) {
//            int count = hs.getOrDefault(num, 0) + 1;
//            hs.put(num, count);
//        }
//        int i = 0;
//        for (int num : arr2) {
//            int size = hs.get(num);
//            while (size > 0){
//                arr1[i] = num;
//                ++i;
//                --size;
//            }
//            hs.remove(num);
//        }
//        TreeSet<Integer> set = new TreeSet(hs.keySet());
//        for (Integer num : set) {
//            int size = hs.get(num);
//            while (size > 0){
//                arr1[i] = num;
//                ++i;
//                --size;
//            }
//            hs.remove(num);
//        }
//        return arr1;
//    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1010];
        for (int num : arr1) {
            arr[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            int size = arr[num];
            while (size > 0){
                arr1[i++] = num;
                --size;
            }
            arr[num] = 0;
        }
        int len = arr.length;
        for (int k = 0; k < len; ++k) {
            while (arr[k] > 0){
                arr1[i++] = k;
                --arr[k];
            }
        }
        return arr1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String l1 = br.readLine();
        String l2 = br.readLine();
        String[] l1_str = l1.split(",");
        String[] l2_str = l2.split(",");
        int len_1 = l1_str.length;
        int len_2 = l2_str.length;
        int[] arr1 = new int[len_1];
        int[] arr2 = new int[len_2];
        for (int i = 0; i < len_1; ++i){
            arr1[i] =  Integer.parseInt(l1_str[i]);
        }
        for (int i = 0; i < len_2; ++i){
            arr2[i] =  Integer.parseInt(l2_str[i]);
        }
        arr1 = relativeSortArray(arr1, arr2);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
