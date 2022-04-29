package a_BinaryAlgorithm;

import java.util.Scanner;

/**
 * @problem 790数的三次方根
 * @idea 二分法
 */
public class T790 {
    public static void main(String[] args) {
        double n = new Scanner(System.in).nextDouble();
        cubeRoot(n);
    }

    private static void cubeRoot(double n) {
        double l, r;
        double abs_n = Math.abs(n);
        if(abs_n <= 1){
            l = abs_n;
            r = 1;
        }else {
            l = 1;
            r = abs_n;
        }
        while (r - l > 1e-8){
            double mid = (l + r) / 2;
            if(mid * mid * mid <= abs_n) l = mid;
            else r = mid;
        }
        System.out.println(String.format("%.6f", n >= 0 ? l : -l));
    }
}
