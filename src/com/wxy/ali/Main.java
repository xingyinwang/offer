package com.wxy.ali;

/**
 * Created by Cser_W on 2018/4/2.
 */
public class Main {

    /*
    * 1357
    * */
    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,1,1};
        int maxProfit = new Main().maxProfit(arr);
        System.out.println(maxProfit);
    }
    public int maxProfit(int[] array) {
        int buyMoney = array[0];
        int sellMoney = array[0];
        int buyIndex = 0;
        int sellIndex = 0;
        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < buyMoney) {
                buyMoney = array[i];
                buyIndex = i;
            } else if (array[i] > sellMoney || sellIndex <= buyIndex){
                sellMoney = array[i];
                sellIndex = i;
            }
            if (sellIndex > buyIndex) {
                maxProfit = maxProfit > sellMoney - buyMoney ? maxProfit : sellMoney - buyMoney;
            }
        }
        return maxProfit;
    }




    /*public int maxProfit(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
       int minPrice = array[0];
        int maxProfit = 0;
        for (int i = 0; i < array.length; i++) {
            maxProfit = Math.max(maxProfit, array[i] - minPrice);
            minPrice = Math.min(minPrice,array[i]);
        }

        return maxProfit;
    }*/
}
