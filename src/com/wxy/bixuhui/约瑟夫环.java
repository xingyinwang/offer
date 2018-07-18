package com.wxy.bixuhui;

import com.wxy.utils.BuildList;
import com.wxy.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cser_W on 2018/4/17.
 */
public class 约瑟夫环 {
    public static void main(String[] args){
        //int res = getLastNode(10,2);
        //System.out.println(res);
        yuesefu(10,2);
    }

    public static int getLastNode(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        ListNode list = new BuildList().createList(arr);
        int count = n;
        int index = 1;
        ListNode lHead = list;
        while (count > 0) {
            if (index == m - 1){
                if (lHead.next == null) {
                    list = list.next;
                    lHead = list;
                }
                else {
                    lHead.next = lHead.next.next;
                }
                index = 0;
            }
            index++;
            if (lHead != null) {
                lHead = lHead.next;
            }
            if (lHead == null) {
                lHead = list;
            }
            count--;
        }
        return lHead.val;
    }

    public static void yuesefu(int totalNum, int countNum) {
       // 初始化人数
       List<Integer> start = new ArrayList<Integer>();
       for (int i = 1; i <= totalNum; i++) {
               start.add(i);
           }
       //从第K个开始计数
       int k = 0;
       while (start.size() > 1) {
               k = k + countNum;
               //第m人的索引位置
               k = k % (start.size()) - 1;
              // 判断是否到队尾
           if (k < 0) {
                   //System.out.println(start.get(start.size()-1));
                   start.remove(start.size() - 1);
                   k = 0;
               } else {
                   //System.out.println(start.get(k));
                   start.remove(k);
               }
           }
       System.out.println(start.get(0));
    }
}
