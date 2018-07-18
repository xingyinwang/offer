package com.wxy.bixuhui;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Cser_W on 2018/4/1.
 *
 * 题目描述
 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 例如输入字符串abc,
 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 全排列 {
    public static void main(String[] args){
     String testStr = "abc";
        ArrayList<String> permutation = new 全排列().Permutation(testStr);
        System.out.println(permutation.toString());
    }
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        PermutationHelper(str.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }

    private void PermutationHelper(char[] str, int i, ArrayList<String> res) {
        if (i == str.length - 1) {
            String val = String.valueOf(str);
            if (!res.contains(val)){
                res.add(val);
                System.out.println(val);
            }
        } else {
            for (int j = i; j < str.length; j++) {
                swap(str,i,j);
                PermutationHelper(str,i + 1, res);
                swap(str, i, j);
            }

        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
