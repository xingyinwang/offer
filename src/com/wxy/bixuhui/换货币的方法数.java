package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/15.
 */
public class 换货币的方法数 {
    public static void main(String[] args){
        int[] array = new int[]{5, 10, 25, 1};
        int aim = 15;
        int res = new 换货币的方法数().changeCoins(array, aim);
        System.out.println(res);
    }

    private int changeCoins(int[] array, int aim) {
        if (array == null || array.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[array.length][aim + 1];
        for (int i = 0; i < array.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i * array[0]<= aim; i++) {
            dp[0][i * array[0]] = 1;
        }

        //int num = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j <= aim ; j++) {
                int num = 0;
                for (int k = 0; j - k * array[i] >= 0; k++) {
                    num += dp[i - 1][j - k * array[i]];
                }
                dp[i][j] = num;
            }
        }
        return dp[array.length - 1][aim];
    }


    /*public int changeCoins(int[] array, int aim) {
        if (array == null || array.length == 0 || aim < 0)
            return 0;
        int[][] map = new int[array.length + 1][ aim + 1];
        return process(array, 0, aim, map);
    }

    private int process(int[] array, int index, int aim, int[][]map) {
        int res = 0;
        if (index == array.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; i * array[index]<= aim; i++) {
                mapValue = map[index + 1][aim - array[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else
                    res += process(array, index + 1, aim - array[index] * i, map);
            }
        }
        map[index][aim] = res== 0 ? -1 : res;
        return res;

    }*/



   /* public int changeCoins(int[] array, int aim) {
        if (array == null || array.length == 0 || aim < 0)
            return 0;
        return process(array, 0, aim);
    }

    private int process(int[] array, int index, int aim) {
        int res = 0;
        if (index == array.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * array[index]<= aim; i++) {
                res += process(array, index + 1, aim - array[index] * i);
            }
        }
        return res;

    }*/
}
