package com.wxy.graph;

/**
 * Created by Kode on 2018/11/9.
 */
public class ListGraphNode {
    // 值
    int value;

    //指向下一个节点的 Node
    ListGraphNode next;

    public ListGraphNode(int value, ListGraphNode next) {
        this.value = value;
        this.next = next;
    }
}
