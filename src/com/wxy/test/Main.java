package com.wxy.test;

/**
 * Created by Cser_W on 2018/3/27.
 */

/**
 *
 * 3 3
 1 1000
 10 1000
 1000000  10001
 9 10 100000000
 * */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int len = in.nextInt();
       int[] array = new int[len];
       for (int i = 0; i < len; i++) {
           array[i] = in.nextInt();
        }
        int start = 0;
       int end = 0;
       while (end < len) {
         if (array[end] != 0) {
             if (start != end) {
                 array[start] = array[end];
                 array[end] = 0;
             }
             start++;
             end ++;
         } else {
             end++;
         }
       }

        for (int i = 0; i < len; i++) {
            System.out.println(array[i]);
        }
    }
}