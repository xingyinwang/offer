package com.wxy.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kode on 2018/7/22.
 */
public class 需要的车辆数 {
    public static void main(String[] args){
       int res = getCham();
       System.out.println(res);
    }
    public static int getCham() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[][] score = new char[M][N];
        for (int i = 0; i < M; i++) {
            score[i] = scanner.next().toCharArray();
        }
        int[] scoreOfEveryOne = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                scoreOfEveryOne[i] += score[j][i];
            }
        }
        int pos = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (min > scoreOfEveryOne[i]) {
                min = scoreOfEveryOne[i];
                pos = i;
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (min == scoreOfEveryOne[i]) {
                count ++;
            }
        }
        if (count >= 2) {
            return -1;
        }
        return pos;
    }
}
