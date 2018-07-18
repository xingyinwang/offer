package com.wxy.multiply;

public class ArraysMul {

    public static void main(String[] args) {

        double start = System.currentTimeMillis();
        int[] array = factorial(10);
        printNum(array);
        double end = System.currentTimeMillis();
        System.out.println();
        System.out.println(end - start);

    }


    /**
     * 计算两个两组的乘
     * @param a
     * @param b
     * @return 用数组表示的数字
     */
    public static int[] mul(int[] a, int[] b) {
        int alen = a.length;
        int blen = b.length;
        int temp = 0;
        int len = alen + blen;
        int[] t = new int[len];
        for (int i = 0; i <= len - 1; i++) {
            t[i] = 0;
        }

        for (int i = 0; i <= alen - 1; i++) {
            for (int j = 0; j <= blen - 1; j++) {
                temp = a[i] * b[j];
                t[j + i] += temp;
            }
        }

        // 将t数组大于10的进行进位操作
        carryBit(t);

        return t;
    }

    /**
     * 将数组表示的数字，每位进行进位操作
     * @param a
     */
    static void carryBit(int[] a) {

        int len = a.length;
        int temp;
        for (int i = 0; i <= len - 2; i++) {
            temp = a[i];
            if (temp >= 10) {
                a[i] = temp % 10;
                a[i + 1] = a[i + 1] + temp / 10;
            }

        }

    }

    /**
     * 打印出数字
     * @param a
     */
    static void printNum(int[] a) {
        int len = a.length;
        int f = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (a[i] > 0) {
                f = 1;
            }
            if (f > 0) {
                System.out.print(a[i]);
            }

        }
    }

    /**
     * * 将一个数字转换为数字表示
     * @param n
     * @return
     */
    static int[] divideNumToArray(int n) {
        int bit = bits(n);

        int[] array = new int[bit];
        int i = 0;
        do {
            array[i++] = n % 10;
            n = n / 10;

        } while (n > 0);
        return array;
    }

    /**
     * 返回一个数字有多少位
     * @param n
     * @return
     */
    static int bits(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n / 10;
            cnt++;
        }

        return cnt;
    }

    /**
     * 求n的阶乘
     * @param n
     * @return
     */
    static int[] factorial(int n){
        int[] result = {1} ;
        if(n<0) {
            System.out.println("input error");
            return  null;
        }
        if(n ==0){
            result = new int[0];
            result[0] = 1;
            return  result;
        }
        int bit = bits(n);
        int[] temp = new int[bit];



        for(int i=1;i<=n;i++){
            temp = divideNumToArray(i);

            result = mul(temp, result);
        }

        return result;
    }

}