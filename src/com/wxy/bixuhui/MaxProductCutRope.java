
package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/6.
 */
public class MaxProductCutRope {
    public static void main(String[] args){
        int i = 1;
        System.out.println(i++);
        System.out.println();
        System.out.println(++i);
    }
    public int maxCutRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        //从 n = 4 开始
        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        for (int i = 4; i < res.length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = res[j] * res[i - j];
                max = max > temp ? max : temp;
                res[i] = max;
            }

        }
        return res[n];
    }

    public double maxCutRopeWithtanxin(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n / 3;
        if (n - timeOf3 * 3 == 1) {
            timeOf3 -= 1;
        }
        int timeOf2 = (n - timeOf3 *3 ) / 2;
        return Math.pow(3,timeOf3) * Math.pow(2, timeOf2);
    }
}
