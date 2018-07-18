package com.wxy.dp;

/**
 * Created by Cser_W on 2018/4/5.
 */
public class coins {
    public static void main(String[] args){
        int[] array = new int[]{5,10,25,1};
        int aim = 15;
        int res = new coins().conis1(array,aim);
        System.out.println(res);
    }
    private int conis1(int[] array, int aim) {
        if (array == null || array.length == 0 || aim < 0) {
            return 0;
        }
        return process1(array, 0, aim);
    }

    private int process1(int[] array, int index, int aim) {
        int res = 0;
        if (index == array.length) {
            res =  aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; array[index] * i <= aim; i++) {
                res += process1(array,index+ 1, aim - array[index] * i);
            }
        }
        return res;
    }
}
