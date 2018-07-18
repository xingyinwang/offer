package com.wxy.test;

import java.math.BigDecimal;

/**
 * Created by Cser_W on 2018/4/27.
 */
public class 丘炜 {
    public static void main(String[] args){

        double pow = Math.pow(2, 10000);
        System.out.println(pow);
        int a = 10;
        int b = 1000000;
        System.out.println(getlog(b,a));

    }

    static double getlog(int b,int a){
        return Math.log(b)/Math.log(a);
    }


        /*  BigDecimal a = new BigDecimal(100);
        BigDecimal b = new BigDecimal(1000000);
        System.out.println(getlog(b,a));
//
    }

    static double getlog(BigDecimal b, BigDecimal a){
        return Math.log(b.doubleValue())/Math.log(a.doubleValue());*/


        /*BigDecimal bg = new BigDecimal(2);
        BigDecimal pow = bg.pow(101);
        BigDecimal p = new BigDecimal(163);
        BigDecimal[] bigDecimals = pow.divideAndRemainder(p);
        for (int i = 0; i < bigDecimals.length; i++) {
            System.out.print(bigDecimals[i] +"\t");
        }*/
   // }
   /* private static void calc() {
        int alpha = 2;
        int p = 163;
        double res = 0;
        BigDecimal e = new BigDecimal(Math.E);
        for (int x = 1; x < p - 2; x++) {
            for (int y = 0; y < p - 1; y++) {
                for (int i = 0; i < p - 1; i++) {
                    BigDecimal theta = e.pow((int) (2 * Math.PI * i / (p - 1)));
                    // double theta = Math.pow(Math.E, 2 * Math.PI * i /( p - 1));

                    BigDecimal yita = e.pow((int) (2 * Math.PI * i / p));
                    //double yita = Math.pow(Math.E, 2 * Math.PI * i / p);
                    theta.pow()
                    double f = Math.pow(theta,x * (Math.log(i)/Math.log(alpha)))
                            * Math.pow(yita,y * Math.pow(i,2));
                    System.out.println("x= " +x+ ": y ="+y+": i= "+i+":f= "+f);
                }
            }
        }*/
   // }
}
