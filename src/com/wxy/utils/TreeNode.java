package com.wxy.utils;

/**
 * Created by Cser_W on 2018/4/14.
 */
public class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(int val){
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TreeNode)) {
            return false;
        }

        TreeNode treeNode = (TreeNode) o;

        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return val;
    }
}