package com.wxy.jd;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[] result = new long[2];
        for(int i = 0; i < t; ++i){
            long N = scanner.nextLong();
            long Y = 1;
            if((N & 1) == 1){
                System.out.println("No");
                continue;
            }
            while(N > 0){
                if((N & 1) == 0){
                    N >>= 1;
                    Y <<= 1;
                }else{
                    break;
                }
            }
            if(N == 0){
                System.out.println("No");
                continue;
            }else{
                System.out.println(N + " " + Y);
            }

        }
    }
}






/*
package com.wxy.jd;

import java.util.Scanner;

*/
/**
 * Created by Cser_W on 2018/4/9.
 *//*

    public class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            //int t = in.nextInt();
           // while (t-- > 0) {//注意while处理多个case
               long n = in.nextLong();
               int[] array = new int[(int)n];
                for (int i = 0; i < n; i++) {
                    array[i] = in.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    printCom(array[i]);
                }
            //}

        }

    private static void printCom(long n) {
        if (n % 2 == 1)
            System.out.println("No");
        long y = 2;
        long count = 1;
        long x = 0;
        long miny = Long.MAX_VALUE;
        while (n / y != 0) {
            if (n % y == 0)
                x = n / y;
            if (x % 2 == 1 && y < miny)
                miny = y;
            y = y *(++count);

        }
        if (miny == Long.MAX_VALUE)
            System.out.println("No");
        else
            System.out.println(n/ miny+" "+miny);
    }
}
*/
