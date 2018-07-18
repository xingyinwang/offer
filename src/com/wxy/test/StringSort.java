package com.wxy.test;

import java.util.*;

/**
 * Created by Cser_W on 2018/3/28.
 */
public class StringSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsValue(str.charAt(i))) {
                map.put(str.charAt(i),1);
            } else {
                map.put(str.charAt(i),map.get(str.charAt(i))+ 1);
            }
        }

        TreeMap<Integer, Character> res = new TreeMap<>();
        for (Map.Entry<Character, Integer> set : map.entrySet()){
            res.put(set.getValue(), set.getKey());
        }
        Iterator<Character> iterator = res.values().iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }


    }
}
