package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/16.
 */
public class 丑数 {
    public static void main(String[] args){
        int res = uglyNumber(1500);
        System.out.println(res);
        int res1 = GetUglyNumber_Solution(1500);
        System.out.println(res1);
    }

    public static int uglyNumber(int index) {
        if(index < 0) {
            return 0;
        }
        int[] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int nextPos = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextPos < index) {
            int min = Math.min(uglyNumber[p2] * 2, Math.min(uglyNumber[p3] * 3, uglyNumber[p5] * 5));
            uglyNumber[nextPos] = min;
            while (uglyNumber[p2] * 2 <= uglyNumber[nextPos]) {
                p2++;
            }
            while (uglyNumber[p3] * 3 <= uglyNumber[nextPos]) {
                p3++;
            }
            while (uglyNumber[p5] * 5 <= uglyNumber[nextPos]) {
                p5++;
            }
            ++ nextPos;
        }
        return uglyNumber[nextPos - 1];
    }

    private static int min(int i1, int i2, int i3) {
        int min = Math.min(Math.min(i1, i2),i3);
        return min;
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int nextUglyNum = 1;
        while(nextUglyNum < index) {
            int minNum = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
            uglyNumbers[nextUglyNum] = minNum;
            while (uglyNumbers[p2]*2 <= uglyNumbers[nextUglyNum]) {
                p2++;
            }
            while (uglyNumbers[p3]*3 <= uglyNumbers[nextUglyNum]) {
                p3++;
            }
            while (uglyNumbers[p5]*5 <= uglyNumbers[nextUglyNum]) {
                p5++;
            }
            nextUglyNum ++;

        }
        int ugly = uglyNumbers[uglyNumbers.length - 1];
        return ugly;
    }
}
