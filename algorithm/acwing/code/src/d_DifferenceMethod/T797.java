package d_DifferenceMethod;

import java.util.Scanner;

public class T797 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; ++i){
            a[i] = sc.nextInt();
            b[i] = a[i] - a[i - 1];
        }
        while (m > 0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();
            b[l] += c;
            if(r < n) b[r + 1] -= c;
            --m;
        }
        for (int i = 1; i <= n; i++) {
            a[i] = a[i - 1] + b[i];
            System.out.print(a[i] + " ");
        }
    }
}
