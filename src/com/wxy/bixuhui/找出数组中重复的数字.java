package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 找出数组中重复的数字 {
    public static void main(String[] args){
        int[] arr = new int[]{2,4,1,3,3,5};
        int res = 0;
        int num = findRepeatNum(arr ,res);
        System.out.println(num);
    }
    public static int findRepeatNum(int[] array ,int res) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("输入错误！");
        }
       res = -1;
        for (int i = 0; i < array.length; i++) {
            while (array[i] != i) {
                if (array[array[i]] == array[i]) {
                    res = array[i];
                    return res;
                }
                int temp = array[array[i]];
                array[array[i]] = array[i];
                array[i] = temp;

            }
        }
        return res;
    }
}
