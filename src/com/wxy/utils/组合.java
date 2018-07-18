package com.wxy.utils;

/**
 * Created by Cser_W on 2018/4/9.
 */
public interface 组合 {
    public static void main(String[] args){
     int res = c(500,2)  ;
     System.out.println(res);
    }
    public static int c(int m,int n){
//temp 为答案
        double temp = 1;
//保证n>=m-n
        if(n<m-n) {
            return c(m, m - n);
        }
        for(int i=0;i<m-n;++i){
            temp*=n+i+1;
            temp/=i+1;
        }

        return (int)temp;
    }
}
