package com.wxy.tree;

import com.wxy.utils.BuildTree;
import com.wxy.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Cser_W on 2018/4/14.
 */
public class 遍历树的六种方式 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 6, 14, 4, 8, 12, 16};
        TreeNode root = new BuildTree().createTree(array);
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> integers = aftOrderWithNoRe(root, res);
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
    }

    //后序非递归遍历
    public static ArrayList<Integer> aftOrderWithNoRe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode cur = root;
        s1.push(cur);
        while (!s1.empty()) {
            TreeNode pop = s1.pop();
            s2.push(pop);
            if (pop.left != null) {
                s1.push(pop.left);
            }
            if (pop.right != null) {
                s1.push(pop.right);
            }
        }
        while (!s2.empty()){
            res.add(s2.pop().val);
        }
        return res;
    }

    //后序递归遍历
    public static ArrayList<Integer>  aftOrderWithRe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }
        aftOrderWithRe(root.left, res);
        aftOrderWithRe(root.right, res);
        res.add(root.val);
        return res;
    }

    //非递归中序遍历
    public static ArrayList<Integer> inOrderWithNoRe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    //递归中序遍历
    public static ArrayList<Integer> inOrderWithRe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        } else {
            inOrderWithRe(root.left, res);
            res.add(root.val);
            inOrderWithRe(root.right, res);

        }
        return res;
    }


    //递归先序遍历
    public static ArrayList<Integer> preOrderWithRe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        } else {
            res.add(root.val);
            preOrderWithRe(root.left, res);
            preOrderWithRe(root.right, res);
        }
        return res;
    }

    //非递归先序遍历
    public static ArrayList<Integer> preOrderWithNORe(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }


}
