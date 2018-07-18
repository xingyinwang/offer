package com.wxy.bixuhui;

/**
 * Created by Cser_W on 2018/4/13.
 */
public class 字母位置调换 {
    public static void main(String[] args) {
        String str = "AaBbCcDd";
        String res = getResult(str);
        System.out.println(res);
    }

    public static String getResult(String str) {
        return str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]", "");
    }
}
