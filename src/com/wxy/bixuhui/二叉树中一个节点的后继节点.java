package com.wxy.bixuhui;

import com.wxy.utils.TreeNode;

/**
 * Created by Cser_W on 2018/4/15.
 */
public class 二叉树中一个节点的后继节点 {

    public TreeNode getNextNdoe(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeNode parent = node.parent;
            while (parent != null && node == parent.left){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }
}
