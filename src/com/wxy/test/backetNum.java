package com.wxy.test;

/**
 * Created by Cser_W on 2018/4/11.
 */
public class backetNum {
    public static void main(String[] args){
       /* Integer count = count(4);
        System.out.println(count);*/
       int n = 4;
       String str = "";
       printSubString(str,1,1,n);
    }

    private static void printSubString(String str, int i, int j, int n) {
        if (j > n) {
            return;
        }
        if (i == n ) {
            for (int k = 0; k <= n - k; k++) {
                str+=")";
            }
            System.out.println(str);
            return;
        }

        printSubString(str +"(",i + 1,j,n);


        printSubString(str+")",i,j+1,n);


    }

    private static Integer count(int num){
        int[] count = new int[num+1] ;
        count[0] = 1 ;
        count[1] = 1 ;
        for(int i=2;i<=num;i++){
            for(int j=0;j<i;j++){
                count[i] += count[j]*count[i-j-1] ;
                System.out.println("count[i] is:"+count[i]) ;
            }
        }

        return count[num] ;
    }
}
