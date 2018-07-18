package com.wxy.dp;

/**
 * Created by Cser_W on 2018/4/5.
 */
public class minCoins {
    public static void main(String[] args){
        int[] array = new int[]{5,3};
        int aim = 2;
        int res = new minCoins().minCoin(array, aim);
        System.out.println(res);
    }
    private int minCoin(int[] array, int aim) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int rows = array.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[rows][aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
            if (i - array[0] >=0 && dp[0][i-array[0]] != max) {
                dp[0][i] = dp[0][i - array[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - array[i] >= 0 && dp[i][j - array[i]] != max) {
                    left = dp[i][j - array[i]] + 1;
                }
                dp[i][j] = Math.min(dp[i-1][j],left);
            }
        }
       return dp[rows - 1][aim] != max ? dp[rows - 1][aim] : -1;
    }
}
