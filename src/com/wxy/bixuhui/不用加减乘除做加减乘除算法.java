package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/27.
 */
public class 不用加减乘除做加减乘除算法 {
    public static void main(String[] args){
        int add = add(2, 3);
        System.out.println(add);
        int minus = minus(2, 3);
        System.out.println(minus);
        int multi = multi(2, 3);
        System.out.println(multi);
        int divide = divide(6, 2);
        System.out.println(divide);
    }

    public static int divide(int a, int b) {
        int x = isNeg(a) ? -a : a;
        int y = isNeg(b) ? -b : b;
        int res = 0;
        for (int i = 31; i >= 0 ; i--) {
            if ( (x >> i) >= y) {
                res = res | (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }
    // true 为 负数， false 为正数
    private static boolean isNeg(int n) {
        return  n < 0;
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ( (b & 1) != 0) {
                res = add(res, a);
            }
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }


    public static int minus(int a, int b) {
        return add(a,negNum(b));
    }

    private static int negNum(int b) {
        return add(~b ,1);
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;  // 不带进位的加法
            b = (a & b) << 1; //计算进位的值
            a = sum;
        }
        return sum;
    }
}
