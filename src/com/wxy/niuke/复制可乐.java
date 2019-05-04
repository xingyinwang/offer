package com.wxy.niuke;

import java.util.Scanner;

/**
 * Created by Kode on 2018/7/22.
 */
public class 复制可乐 {
    public static void main(String[] args){
     String[] str = {"Alice", "Bob","Cathy","Dave"};
     int res = getPeople();
        String s = str[res];
        System.out.println(s);
    }
    public static int getPeople() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int n = (int)(Math.log(N + 2)/Math.log(2)) - 1;
        int Sn = (int) (Math.pow(2, n + 1) - 2);
        int delat = N - Sn;
        int res = delat % (n - 1) + 1;
        return res;
    }
}
