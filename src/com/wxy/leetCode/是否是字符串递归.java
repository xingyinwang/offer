package com.wxy.leetCode;

/**
 * Created by Cser_W on 2018/5/23.
 */
public class 是否是字符串递归 {
    public static void main(String[] args){
        boolean palindrome = new 是否是字符串递归().isPalindrome(" .a9b.");
        System.out.println(palindrome);
    }
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        //需要考虑 单词大写、标点符号
        int len = s.length();
        //想法一：先生成一个新的字符串 然后开始判断
        //递归（一定要用递归解决）
        return isPalinDrome(s, 0, len - 1);
    }
    private boolean isPalinDrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (!Character.isLetterOrDigit(s.charAt(start))) {
            return isPalinDrome(s, start + 1, end);
        } else if(!Character.isLetterOrDigit(s.charAt(end))) {
            return isPalinDrome(s, start , end - 1);
        }else if (Character.toLowerCase(s.charAt(start)) !=
                Character.toLowerCase(s.charAt(end))) {
            return false;
        } else {
            return isPalinDrome(s, start + 1, end - 1);
        }
    }
}
