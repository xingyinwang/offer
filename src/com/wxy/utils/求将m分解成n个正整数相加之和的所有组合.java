package com.wxy.utils;

/**
 * Created by Cser_W on 2018/4/9.
 */
public class 求将m分解成n个正整数相加之和的所有组合 {

        public void combine(int m, int n) {

            if(m < 1 || n < 1) {
                return;
            }

            int[] b = new int[n];
            getCombination(m, n, b, 0, 1);
        }
        private void getCombination(int m, int n, int[] b, int index, int begin) {
            // TODO Auto-generated method stub
            if(n == 0 && m == 0){
                for(int i = 0; i < b.length; i++) {
                    System.out.print(b[i] + " ");
                }
                System.out.println();
            }
            if(n == 0) {
                return;
            }

            for(int i = begin; i <= m; i++){
                b[index] = i;
                getCombination(m-i,n-1,b ,index+1,i);

            }

        }

        public static void main(String[] args){

            求将m分解成n个正整数相加之和的所有组合 robot = new 求将m分解成n个正整数相加之和的所有组合();
            robot.combine(5,3);

        }

}

