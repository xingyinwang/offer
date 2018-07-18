package com.wxy.niuke;

import java.util.Scanner;

/**
 * Created by Cser_W on 2018/3/31.
 */
public class mod3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        int count = 0;
        int leftCount = 0;
        int rigthCount =0;
        if (l % 3 <= 1) {
            leftCount = (l / 3) * 2;
        } else {
            leftCount = l % 3  + (l / 3) * 2 - 1;
        }
        if (r % 3 <= 1) {
            rigthCount = (r / 3) * 2;
        } else {
            rigthCount = r % 3 + (r/3) * 2 - 1;
        }
        if(l % 3 != 1){
            System.out.println(rigthCount - leftCount + 1);
        } else{
            System.out.println(rigthCount - leftCount);
        }
    }
}
