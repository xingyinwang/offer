package com.wxy.leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Cser_W on 2018/4/21.
 */
public class 第K个字符排列 {
    public static int k ;
    public static void main(String[] args){
     int n = 3;
     //int k = 3;
        k = 5;
        String permutation = new 第K个字符排列().getPermutation(n, k);
        System.out.println(permutation);
    }
    public String getPermutation(int n, int k) {

        if (n <= 0 || k < 0) {
            return null;
        }
        char[] chas = new char[n];
        for (int i = 0; i < n; i++) {
            chas[i] = (char)(1 + i + '0');
        }
        PriorityQueue<String> res = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        getPermutation(chas, 0,  res);
        return (String) res.toArray()[k - 1];
    }
    private void getPermutation(char[] chas, int index, PriorityQueue<String> res){
        if(index == chas.length){
            k--;
            if (0 <= k) {
                res.add(new String(chas));
            }
            return;
        }
        for (int i = index; i < chas.length; i++) {
            swap(chas,i, index);

            getPermutation(chas, index + 1,  res);
            swap(chas, i, index);
        }
        return ;
    }
    private void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
    }

    //第二种方法
    public String getPermutation2(int n, int k) {
        if (n == 0) {
            return null;
        }
        ArrayList<Integer> num = new ArrayList<>();
        for (int i=0; i < n; i++) {
            num.add(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        int fact = 1;
        for(int i = 1; i < n; i++) {
            fact *= i;
        }
        k = k - 1;
        for (int i = n - 1; i > 0; i--) {
            int index = k / fact;
            sb.append(num.get(index));
            num.remove(index);
            k = k % fact;
            fact = fact / i;
        }
        sb.append(num.get(0));
        return sb.toString();
    }
}
