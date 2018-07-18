package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 最大利润问题一 {
    public static void main(String[] args){
        int[] array = new int[]{4,3,2,1,1,1};
        int res = maxProfit(array);
        System.out.println(res);
    }

    public static int maxProfit(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int minPrcie = array[0];
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            minPrcie = Math.min(minPrcie, array[i]);
            max = Math.max(max, array[i] - minPrcie);
        }
        return max;
    }
}
