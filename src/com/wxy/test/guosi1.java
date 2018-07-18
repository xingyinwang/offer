package com.wxy.test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Cser_W on 2018/4/10.
 */
public class guosi1 {
    public static void main(String[] args){

        ConcurrentHashMap<Integer, Integer> conCurrentHashMap = new ConcurrentHashMap<>();
        conCurrentHashMap.put(1,2);
        conCurrentHashMap.put(3,4);
        Integer integer = conCurrentHashMap.get(1);
        System.out.println(integer);
        String str1 = "abc"+"def";
        String str2 = new String(str1);
        System.out.println(str1.equals(str1));


       /* Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            int pos = sc.nextInt();
            arr[pos] = pos + 1;
        }
        for (int i = 0; i <= n; i++) {
            if (arr[i] == 0)
                System.out.print(i);
        }*/
    }
}
