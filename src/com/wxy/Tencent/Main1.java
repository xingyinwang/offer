package com.wxy.Tencent;

import java.util.Scanner;

/**
 * Created by Cser_W on 2018/4/5.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int k = in.nextInt();
            int a = in.nextInt();
            int x = in.nextInt();
            int b= in.nextInt();
            int y = in.nextInt();

            System.out.println();
         }




    }
    private long nnumber(int k, int a, int x, int b, int y) {
        if ((k != (a + b)) && (k % a != 0 || k % b != 0)) {
            {
                return 0;
            }
        }
        long res = 0;
        if (k == (a + b)){
            res = (x * y) % 1000000007;
        } else if (k % a == 0) {
            int temp = k / a;
            res = zuhe(x,temp) % 1000000007;
        } else if (k % b == 0) {
            int temp = k / b;
            res = zuhe(y,temp) % 1000000007;
        }
        return res % 1000000007;
    }


    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }


    public long zuhe(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
}
