package com.wxy.leetCode;

import java.util.ArrayList;

/**
 * Created by Cser_W on 2018/5/19.
 */
public class 拆分字符串变成回文串 {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    ArrayList<String> temp = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<ArrayList<String>> partition = new 拆分字符串变成回文串().partition("aab");
        System.out.println(" ");
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        findLindrome(s, 0);
        return result;
    }

    private void findLindrome(String s, int left) {
        if (temp.size() > 0 && left >= s.length()) {
            //ArrayList<String> tempList = (ArrayList<String>) temp.clone();
            result.add(new ArrayList<String>(temp));
            return;
        }
        for (int right = left; right < s.length(); ++right) {
            String strTemp = s.substring(left, right + 1);
            if (isParlindrome(strTemp)) {
                temp.add(strTemp);
                findLindrome(s, right + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isParlindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.substring(0, s.length() / 2).equals(
                new StringBuffer(s.substring((s.length() / 2 + s.length() % 2))).reverse().toString())) {
            return true;
        }
        return false;
    }
}
