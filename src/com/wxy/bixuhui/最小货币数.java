package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/14.
 */
public class 最小货币数 {
    public static void main(String[] args){


        int aim = 26;
        int[] array = new int[]{2,3,5};
        int res = minCoins1(array,aim);
        System.out.println(res);
    }

    //递归的解法
    public static int minCoins1(int[] array, int aim) {
        if (aim == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            int tempAim = aim - array[i];
            if (tempAim < 0) {
                continue;
            } else {
                int res = minCoins1(array, tempAim);
                if (res < min) {
                    min = res;
                }
            }
        }
        return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
    }
    /* public static int minCoins(int[] array, int aim) {
         int len = array.length;
         int[][] dp = new int[len][ aim + 1];
         int max = Integer.MAX_VALUE;
         //处理第一行数据
         for (int i = 1; i <= aim ; i++) {
            dp[0][i] = max;
             if (i-array[0] >=0 && dp[0][i- array[0]] != max) {
                 dp[0][i] = dp[0][i-array[0]] + 1;
             }
         }
         int left = 0;
         for (int i = 1; i < len; i++) {
             for (int j = 1; j <= aim; j++) {
                 left = max;
                 if (j - array[i] >= 0 && dp[i][j- array[i]] != max) {
                     left = dp[i][j - array[i]] + 1;
                 }
                 dp[i][j] = Math.min(left, dp[i-1][j]);
             }
         }
         return dp[len-1][aim] != max ?dp[len-1][aim]  : -1;
     }*/
}
