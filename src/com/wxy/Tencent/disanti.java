package com.wxy.Tencent;

import java.util.Scanner;

/**
 * Created by Kode on 2018/9/16.
 */
public class disanti {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[][] data = new int[t][3];
        for (int i = 0; i < t; i++) {
            data[i][0] = scanner.nextInt();
            data[i][1] = scanner.nextInt();
            data[i][2] = scanner.nextInt();
        }

        boolean flag = true;
        for (int i = 0; i < t; i++) {
            flag = yesOrNo(data[i][0], data[i][1], data[i][2]);
            if (flag == true) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    public static boolean yesOrNo(int a, int b, int c) {
        int i = 1;
        while (i < 10000) {
            if ((a * i - c) % b == 0) {
                return true;
            }
            i++;
        }
        return false;
    }
}
