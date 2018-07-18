package com.wxy.niuke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Cser_W on 2018/3/31.
 */
public class niuniuFindJob {
    public static void main(String[] args){
        int N, M; //N项任务。M个工人
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();

        int t1 = 0, t2 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] a = new int[M+N];
        int[] b = new int[M];
        for (int i = 0; i < N; i++) {
            t1 = in.nextInt();
            t2 = in.nextInt();
            a[i] = t1;
            map.put(t1,t2);
        }

        for (int i = 0; i < M; i++) {
            t1 = in.nextInt();
            a[N+i] = t1;
            b[i] = t1;
            if (!map.containsKey(t1)) {
                map.put(t1, 0);
            }
        }
        Arrays.sort(a);
        int max = 0;
        for (int i = 0; i < M + N; i++) {
            max = Math.max(max,map.get(a[i]));
            map.put(a[i],max);
        }
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(b[i]));
        }

    }
}
