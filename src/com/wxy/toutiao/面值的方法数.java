package com.wxy.toutiao;

import java.util.Scanner;

/**
 * Created by Cser_W on 2018/4/19.
 */
public class 面值的方法数 {
    public static void main(String[] args){
        int MOD = 1000000007;
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) {
            b[i] = in.nextInt();
        }
        int[] f = new int[m];
        f[0] = 1;
        for (int i = 0; i < n1; i++) {
            for (int j = a[i]; j <= m; j++) {
                f[j] += f[j - a[i]];
                if (f[j] > MOD) {
                    f[j] -= MOD;
                }
            }
        }
    }
}
