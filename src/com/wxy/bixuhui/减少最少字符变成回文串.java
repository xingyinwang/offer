package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/12.
 */
public class 减少最少字符变成回文串 {
    public static void main(String[] args){
        String str = "abcdawsadasdsadsaada";
        int res = reduceStr(str);
        System.out.println(res);
    }
    public static int reduceStr(String str) {
        String str1 = new StringBuilder(str).reverse().toString();
        int len = str.length() ;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len ; i++) {
            for (int j = 1; j <= len ; j++) {
                if (str.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j- 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return str.length() - dp[len][len];
    }
}
