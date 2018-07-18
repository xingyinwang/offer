package com.wxy.niukewang;

/**
 * Created by Cser_W on 2018/3/28.
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class niuniuFindJob{
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader("E:\\IDEACode\\offer\\src\\1000");
        Scanner in = new Scanner(fileReader);
        while(in.hasNextInt()) {
            int N = in.nextInt();
            int M = in.nextInt();
            int[] d = new int[N];
            int[] p = new int[N];
            for(int i = 0; i < N; i++) {
                d[i] = in.nextInt();
                p[i] = in.nextInt();
            }
            int[] a = new int[M];
            for(int i = 0; i < M; i ++) {
                a[i] = in.nextInt();
            }
            // d 进行排序
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                treeMap.put(d[i], i);
            }
            for (int i = 0; i < M; i ++) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                for (Integer temp : treeMap.keySet()) {
                    if (temp <= a[i]) {
                        int index = treeMap.get(temp);
                        treeSet.add(p[index]);
                    }
                }
                if (!treeSet.isEmpty()) {
                    System.out.println(treeSet.last());
                }
            }
        }
    }
}