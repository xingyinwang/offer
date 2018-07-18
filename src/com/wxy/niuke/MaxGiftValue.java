package com.wxy.niuke;

/**
 * Created by Cser_W on 2018/4/4.
 */
public class MaxGiftValue {
    public static void main(String[] args){
        int[][] array = new int[][]{{1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}};
     int res = new MaxGiftValue().maxGiftValue(array);
     System.out.println(res);
    }

    private int maxGiftValue(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[] maxValues = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = maxValues[j];
                }
                if (j > 0) {
                    left = maxValues[j - 1];
                }
                maxValues[j] = Math.max(up,left) + array[i][j];
            }
        }
        return maxValues[cols - 1];
    }



    /*
      //没有优化
    private int maxGiftValue(int[][] array){
        if (array == null || array.length == 0)
            return 0;
        int rows = array.length;
        int cols = array[0].length;
        int[][] dp = new int[rows ][ cols ];
        dp[0][0] = array[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + array[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]) + array[i][j];
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }
        return max;
    }
    */
}
