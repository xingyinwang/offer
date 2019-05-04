package com.wxy.wangyi;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by Kode on 2018/9/10.
 */
public class FinallyCatchDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int res = new FinallyCatchDemo().getAns(n, m, k);
        System.out.println(res);
    }
    public  int getAns(int n, int m ,int k) {
        if (k == 0) {
            return 0;
        }
        if ( k == 1) {
            return 4;
        }
        if (k == 2) {
            return 2;
        }
        if (k == 3) {
            return 4;
        }
        if (k == 4) {
            return 1;
        }
        int total = 2 * m + 2 * (n - 1);
        if (k <= total) {
            return 1 + com(k - 4, total - 4);
        } else {
            return 1 + getAns(n - 1, m - 1, k - total);
        }
    }
    @Test
    public void test(){
        int n = 14;
        int m = 2;
        int com = new FinallyCatchDemo().com(2, 14);
        System.out.println(com);
    }
    public  int com(int m, int n) {
        System.out.println("fac(n) ="+fac(n));
        System.out.println("fac(n - m) ="+fac(n - m));
        return m < n ? fac(n)/(fac(m) * fac(n - m)) : 0;

    }
    private  int fac(int n) {
        int res = 1;
        while (n > 0) {
            res *= n;
            n--;
        }
        return res;
    }
}
