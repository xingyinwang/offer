package com.wxy.niuke;

/**
 * Created by Cser_W on 2018/4/4.
 */
public class longestSubStringWithoutRepeat {
    public static void main(String[] args){
        String str = "aaaaaa";
        int res = new longestSubStringWithoutRepeat().longestSubString(str);
        System.out.println(res);
    }
    private int longestSubString(String str){
        if (str == null || str.length() == 0) {
            return 0;
        }
        int max = 0;
        int f0 = 0;
        int f1 = 0;
        int[] appear = new int[26];
        for (int i = 0; i < appear.length; i++) {
            appear[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (appear[str.charAt(i) - 'a'] == -1) {
                appear[str.charAt(i) - 'a'] = i;
                f1 = f0 + 1;
                //f0 = f1;
                max = max > f1 ? max : f1;
            } else {
                int d = i - appear[str.charAt(i) - 'a'];
                if (d > f0) {
                    f1 = f0;
                    //f0 = f1;
                    max = max > f0 ? max : f0;
                } else {
                    f1 = d;
                   // f0 = f1;
                    max = max > d ? max : d;
                }

            }
            f0 = f1;
        }
        return max;
    }
}
