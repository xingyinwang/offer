package com.wxy.utils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cser_W on 2018/4/3.
 */

public class BuildTree {
    public TreeNode createTree(int[] array){
        List<TreeNode> listNode = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            listNode.add(new TreeNode(array[i]));
        }
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            listNode.get(parentIndex).left = listNode.get(parentIndex * 2 + 1);

            listNode.get(parentIndex).right = listNode.get(parentIndex * 2 + 2);
        }
        int lastParentIndex = array.length / 2 - 1;
        listNode.get(lastParentIndex).left = listNode.get(lastParentIndex * 2 + 1);
        if (array.length % 2 == 1) {
            listNode.get(lastParentIndex).right = listNode.get(lastParentIndex * 2 + 2);
        }
        return listNode.get(0);
    }
}
