package com.wxy.toutiao;

import java.util.*;

/**
 * Created by Cser_W on 2018/4/15.
 */
public class 第K小的数 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int hangshu = in.nextInt();
        while (hangshu > 0) {
            hangshu--;
            int kth = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            while (in.hasNextLine()) {
                if (in.nextInt() == -1) {
                    break;
                }
                list.add(in.nextInt());
            }

            //排序list
            Collections.sort(list);
            double[] array = new double[kth];
            TreeMap<Double, HashMap<Integer, Integer>> treeMap = new TreeMap<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    double temp = (double)list.get(i)/(double)list.get(j);
                    treeMap.put(temp, new HashMap<>(list.get(i),list.get(j)));
                }
            }
            for (int i = 0; i < kth; i++) {
                if (i == kth-1) {
                    HashMap<Integer, Integer> hashMap = treeMap.get(i);
                    for (Integer integer : hashMap.keySet()) {
                        System.out.println(integer+" "+ hashMap.get(integer));
                    }
                    continue;
                }
            }
        }
    }
}
