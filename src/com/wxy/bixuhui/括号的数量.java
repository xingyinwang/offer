package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 括号的数量 {
    public static void main(String[] args){
     int n = 6;
     blackOfNum(n);
    }

    private static void blackOfNum(int n) {
        if ((n & 1) == 1 ) {
            return;
        }
        int left = 0;
        int right = 0;
        String str = "";
        getPair(n, left, right, str);
    }

    private static void getPair(int n, int left, int right,  String str) {
        if (left + right == n) {
            System.out.print(str);
            return;
        }
        if (left < (n >> 1)) {
            getPair(n, left + 1, right, str +"(");
        }
        if (right < left) {
            getPair(n, left, right + 1, str +")");
        }
    }
}
