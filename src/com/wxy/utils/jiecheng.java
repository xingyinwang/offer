package com.wxy.utils;

import java.math.BigInteger;


/**
 * Created by Cser_W on 2018/4/9.
 */
public class jiecheng {
    public static void main(String[] args){
        fun3(100);
    }
    public static void fun1(Integer n) {
        Long begin = System.currentTimeMillis();
        Integer base = n;
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= base; i++){
            String temp1 = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp1);
            result = result.multiply(temp2);
        }
        System.out.println("" + base + "! = " + result);
        Long end = System.currentTimeMillis();
        System.out.println("运行时间:"+(end - begin));
    }


    public static void fun2(int n) {
        Long begin = System.currentTimeMillis();
        int[] cal = new int[10010];
        int num = n;
        cal[0] = 1;
        for(int index = 1; index <= num; ++index )
        {
            for(int i = 0; i < 10000; i++)
            {
                cal[i] = cal[i]*index;

            }
            for(int i = 0; i < 10000; i++)
            {
                cal[i+4] = cal[i+4]+ cal[i]/10000;
                cal[i+3] = cal[i+3]+ cal[i]%10000/1000;
                cal[i+2] = cal[i+2]+ cal[i]%1000/100;
                cal[i+1] = cal[i+1]+ cal[i]%100/10;
                cal[i+0] = cal[i]%10;
            }
        }
        for(int i3 = 0; i3 < 10004; i3++)
        {
            cal[i3+4] = cal[i3+4]+ cal[i3]/10000;
            cal[i3+3] = cal[i3+3]+ cal[i3]%10000/1000;
            cal[i3+2] = cal[i3+2]+ cal[i3]%1000/100;
            cal[i3+1] = cal[i3+1]+ cal[i3]%100/10;
            cal[i3+0] = cal[i3]%10;
        }
        int x = 10000;
        while(cal[x] == 0) {
            x--;
        }
        for(int i2 = x; i2 >= 0; i2--)
        {
            System.out.print(cal[i2]);
        }
        System.out.println();
        Long end = System.currentTimeMillis();
        System.out.println("运行时间:"+(end - begin));
    }

    public static void fun3(int n) {
        Long begin = System.currentTimeMillis();
        int RAD=10000;
        int buffSize=(int)(n * Math.log10((n+1)/2) / Math.log10(RAD)+1);
        short[] buff = new short[buffSize];
        int len=1;
        buff[0]=1;
        for (int i=1;i<=n;i++){
            int c=0;
            for (int j=0;j<len;j++)
            {
                int prod=(buff[j]*i+c);
                buff[j]=(short)(prod % RAD);
                c=prod / RAD;
            }
            while (c>0)
            {
                buff[len++]= (short)(c % RAD);
                c=c/RAD;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("运行时间:"+(end - begin));
    }

}
