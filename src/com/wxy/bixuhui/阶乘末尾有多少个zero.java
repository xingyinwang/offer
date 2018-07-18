package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/13.
 */
public class 阶乘末尾有多少个zero {
    public static void main(String[] args){
        int n = 5;
        int count = 0;
        int flag = 0;
        int temp = 0;
        for (int i = 5; i <=n ; i++) {
            temp = i;
            flag = temp % 5;
            while (flag == 0) {
                temp = temp / 5;
                flag = temp % 5;
                count += 1;
            }
        }
        System.out.println(count);
        int res = numberOfZero(n);
        System.out.println(res);
    }
    public static int numberOfZero(int n) {
        if (n < 5) {
            return 0;
        }
        return n / 5 + numberOfZero(n / 5);
    }
}
