package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/7.
 */
public class SumChuanchuan {
    public static void main(String[] args){
          int[] array = new int[]{1,2,3,4,5,6,7,8};
          int targrt = 15;
          new SumChuanchuan().sumChuanChuan(array, targrt);
    }

    public void sumChuanChuan(int[] array, int target) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = 1;
        int curSum = array[start] + array[end];
        while (start < end && end < array.length) {
            if (curSum == target) {
                printSeq(array,start, end);
                end++;
                if (end < array.length) {
                    curSum += array[end];
                }
            } else if (curSum < target) {
                if ((end+1) < array.length) {
                    curSum += array[++end];
                }
            } else {
                curSum -= array[start++];
            }
        }
    }

    private void printSeq(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
