package com.wxy.bixuhui;

import com.wxy.utils.BuildTree;
import com.wxy.utils.TreeNode;

/**
 * Created by Cser_W on 2018/4/14.
 */
public class 二叉树转双向链表 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 6, 14, 4, 8, 12, 16};
        TreeNode root = new BuildTree().createTree(array);
        TreeNode convert = Convert(root);
        while (convert != null && convert.right != null) {
            System.out.print(convert.val + "\t");
            convert = convert.right;
        }
    }

    public static TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode preLastNode = null;
        preLastNode = convertTree(root, preLastNode);
        while (preLastNode != null && preLastNode.left != null) {
            preLastNode = preLastNode.left;
        }
        return preLastNode;
    }

    public static TreeNode convertTree(TreeNode root, TreeNode preLastNode) {
        if (root == null) {
            return preLastNode;
        }
        TreeNode pCur = root;
        if (pCur.left != null) {
            preLastNode = convertTree(pCur.left, preLastNode);
        }
        pCur.left = preLastNode;
        if (preLastNode != null) {
            preLastNode.right = pCur;
        }
        preLastNode = pCur;
        if (pCur.right != null) {
            preLastNode = convertTree(pCur.right, preLastNode);
        }
        return preLastNode;
    }
}

/*
*
*  public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = root;
            root.left = p;
        }
        TreeNode right = Convert(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }
        return left != null ? left : root;
    }*/
