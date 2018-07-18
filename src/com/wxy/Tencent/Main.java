package com.wxy.Tencent;

import java.util.Scanner;

/**
 * Created by Cser_W on 2018/4/5.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Long n = in.nextLong();
        long m = in.nextLong();
        if(n % 2* m != 0) {
            return;
        }
        long k = n / (2 * m);
        String str1 = n + "";
        String str2 = m + "";
        String k1 = k + "";
        String res = new Main().multiply(str2, str2);
        String res1 = new Main().multiply("k1",res);
        System.out.println(res1);
    }
    public String multiply(String num1, String num2){

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();


        int[] result = new int[chars1.length + chars2.length];
        int[] n1 = new int[chars1.length];
        int[] n2 = new int[chars2.length];


        for(int i = 0; i < chars1.length;i++) {
            n1[i] = chars1[i] - '0';
        }
        for(int i = 0; i < chars2.length;i++) {
            n2[i] = chars2[i] - '0';
        }

        for(int i =0 ; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }

        for(int i =result.length-1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }
}
