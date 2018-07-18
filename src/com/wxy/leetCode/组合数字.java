package com.wxy.leetCode;

import java.util.ArrayList;

/**
 * Created by Cser_W on 2018/7/2.
 */
public class 组合数字 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> combine = new 组合数字().combine(4, 2);
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        if (n < k || n < 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        combineHelper(n, k, 1, list);
        return res;
    }
    private void combineHelper(int n, int k, int start, ArrayList<Integer> list) {
        if (k < 0) {
            return ;
        }
        else if (k == 0) {
            res.add((ArrayList<Integer>) list.clone());
        }
        else {
            for (int i = start; i <= n; i++) {
                list.add(i);
                combineHelper(n, k - 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
