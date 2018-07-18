package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 先升后降数组中找最大的 {
    public static void main(String[] args){
        int[] array = new int[]{5,4,3,2};
        int max = getMax(array);
        System.out.println(max);
    }
    public static int getMax(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        while (start <= end) {
             mid = (end + start) / 2;
            if (isUp(array, mid)) {
                start = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return array[start];
    }
    public static boolean isUp(int[] array, int index) {
        if (index+ 1 >= array.length) {
            return false;
        }
        if (array[index] <= array[index + 1]) {
            return true;
        }
        return false;
    }
}
