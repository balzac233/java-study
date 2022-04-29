package c_PrefixSum;

import java.util.Scanner;

/**
 * @problem 795.一维前缀和
 * @idea 前缀和算法
 */
public class T795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            s[i + 1] = s[i] + num[i];
        }
        while (m > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(s[r] - s[l - 1]);
            --m;
        }
    }
}
