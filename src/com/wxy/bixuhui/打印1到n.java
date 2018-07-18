package com.wxy.bixuhui;

/**
 *
 * Created by Cser_W on 2018/4/7.
 */
public class 打印1到n {
    public static void main(String[] args){
        int n = 2;
        prinn1ToN(n);
    }

    private static void prinn1ToN(int n) {
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            //开始递归处理
            prinn1ToNWithRe(number, 0);
        }
    }

    private static void prinn1ToNWithRe(char[] number, int index) {
        if (index == number.length - 1){
            printNum(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            prinn1ToNWithRe(number,index + 1);
        }

    }

    private static void printNum(char[] number) {
        boolean isBegin0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegin0 && number[i] != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
   /* public void printNum(int n) {
        if (n < 0)
            return;
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private boolean increment(char[] res) {
        int len = res.length;
        boolean isOver = false;
        int isTakeOver = 0;
        for (int i = len - 1; i >=0 ; i--) {
            int nSum = res[i] - '0' + isTakeOver;

            if (i == len - 1)
                nSum++;
            if (nSum >= 10) {
                if (i == 0) {
                    isOver = true;
                } else {
                    nSum -= 10;
                    isTakeOver = 1;
                    res[i] = (char)(nSum +'0');
                }
            }else {
                res[i] = (char)(nSum +'0');
                break;
            }
        }
        return isOver;
    }

    private void printNumber(char[] number) {
      boolean isBegin0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegin0 && number[i] != '0')
                isBegin0 = false;
            if (!isBegin0)
                System.out.print(number[i]);
        }
        System.out.println();
    }*/
}
