package com.wxy.niuke;

import java.util.Scanner;

/**
 * Created by Cser_W on 2018/3/17.
 */
public class hechangtuan {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     int n, kk, dd;
     int[] array = null;
     while (sc.hasNext()) {
         n = sc.nextInt();
         array = new int[n + 1];
         for (int i = 1; i <= n; i++) {
             array[i] = sc.nextInt();
         }
         kk = sc.nextInt();
         dd = sc.nextInt();

         long[][] f = new long[n + 1][kk + 1];
         long[][] g = new long[n + 1][kk + 1];

         for (int one = 1; one <= n; one++) {
             f[one][1] = array[one];
             g[one][1] = array[one];
         }

         for (int k = 2; k <= kk; k++) {
             for (int one = k; one <= n; one ++) {
                 long tempMax = Long.MIN_VALUE;
                 long tempMin = Long.MAX_VALUE;
                 for (int left = Math.max(k - 1, one - dd); left <= n; left ++) {
                     if (tempMax < Math.max(f[left][k - 1] * array[one],g[left][k - 1] * array[one])) {
                         tempMax = Math.max(f[left][k - 1] * array[one], g[left][k - 1] * array[one]);
                     }
                     if (tempMin > Math.max(f[left][k - 1] * array[one],g[left][k - 1] * array[one])) {
                         tempMin = Math.max(f[left][k - 1] * array[one], g[left][k - 1] * array[one]);
                     }
                 }
                 f[one][k] = tempMax;
                 g[one][k] = tempMin;
             }
         }
         long result = Long.MIN_VALUE;
         for (int one = kk; one <= n; one ++) {
             if (result < f[one][kk]) {
                 result = f[one][kk];
             }
         }
         System.out.println(result);
     }
    }
}
