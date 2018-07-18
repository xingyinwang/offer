package com.wxy.bixuhui;

import java.util.Arrays;

/**
 * Created by Cser_W on 2018/4/8.
 *
 * 异或去重
 */

public class 数组中不重复的数字 {

    public static void main(String[] args){
        int[] array = new int[]{4,2,3,2,3,1};
        int[] res = new 数组中不重复的数字().noRepeatNum(array);
        System.out.println(res[0] + ": " + res[1]);
    }
    private int[] noRepeatNum(int[] array) {
        int[] res = new int[2];
        int len = array.length;
        int flag = array[0];
        for (int i = 1; i < len; i++) {
            flag ^= array[i];
        }
        //开始进行分数组
        //先找flag的最右边的位置
        int n = (flag ^ (flag - 1)) & flag;
        for (int i = 0; i < len; i++) {
            int temp = n & array[i];
            if (temp != 0) {
                res[0] ^= array[i];
            } else {
                res[1] ^= array[i];
            }
        }
        return res;
    }
}
