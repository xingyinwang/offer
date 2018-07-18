package com.wxy.bixuhui;

import com.wxy.utils.BuildTree;
import com.wxy.utils.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Cser_W on 2018/4/15.
 */
public class 两个节点的公共祖先 {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode head = new BuildTree().createTree(arr);
        TreeNode res = getAncestot(head, new TreeNode(8), new TreeNode(7));
        System.out.println(res.val);
    }
    public static TreeNode getAncestot(TreeNode head, TreeNode o1, TreeNode o2) {

        //建哈希表
        HashMap<TreeNode, TreeNode> hashMap = new HashMap<>();
        hashMap.put(head, null);
        buildTable(head, hashMap);
        TreeNode node = query(hashMap, o1, o2);
        return node;
    }

    private static TreeNode query(HashMap<TreeNode, TreeNode> hashMap, TreeNode o1, TreeNode o2) {
        HashSet<TreeNode> set = new HashSet<>();
        set.add(o1);
        while (hashMap.containsKey(o1)) {
            set.add(hashMap.get(o1));
            o1 = hashMap.get(o1);
        }
        while (!set.contains(o2)){
            o2 = hashMap.get(o2);
        }
        return o2;
    }

    private static void buildTable(TreeNode head, HashMap<TreeNode, TreeNode> hashMap) {
        if (head == null) {
            return;
        }
        if (head.left != null) {
            hashMap.put(head.left, head);
        }
        if (head.right != null) {
            hashMap.put(head.right, head);
        }
        buildTable(head.left, hashMap);
        buildTable(head.right, hashMap);
    }





    /*public TreeNode getAncestor(TreeNode head, TreeNode o1, TreeNode o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        TreeNode left = getAncestor(head.left, o1, o2);
        TreeNode right = getAncestor(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }*/
}
