package com.wxy.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Kode on 2018/7/22.
 * 130 140 150 160
 */
public class 车辆第三题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
      /*  String str = scanner.nextLine();
        String[] strings = str.split(" ");*/
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int te = scanner.nextInt();
            list.add(te);
            scanner.next();
        }
       /* for (int i = 0; i < strings.length; i++) {
            list.add(Integer.valueOf(strings[i]));
        }*/
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 100) {
                count ++;
            } else {
                break;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        if (count % 3 == 0) {
            for (int i = count; i < list.size(); i++) {
                temp.add(list.get(i));
            }
        } else {
            for (int i = count - (count % 3); i < list.size(); i++) {
                temp.add(list.get(i));
            }
        }
        int res = count / 3;
        int start = 0; int end = temp.size();
        while (start < end) {
            if (temp.get(start) + temp.get(end - 1) <= 300) {
                res += 1;
                start ++;
                end --;

            } else {
                end--;
                res += 1;
            }
        }
        System.out.println(res);
    }
}
