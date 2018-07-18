package com.wxy.lianjia;

/**
 * Created by Cser_W on 2018/4/8.
 */
public class 三角形 {
    public static void main(String[] args){
        int res = new 三角形().num(1000000)   ;
        System.out.println(res);
    }
    public int num(int n) {
        int count = 3;
        int t1 = 3;
        int t2 = 5;
        while (t2 <= n) {
            int temp = t2;
            t2 = t1+t2 ;
            t1 = temp;
            count ++;
        }
        return n - count;
    }
}
