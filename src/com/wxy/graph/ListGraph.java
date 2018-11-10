package com.wxy.graph;

/**
 * Created by Kode on 2018/11/9.
 */
public class ListGraph {
    // 图的顶点数组
    private ListGraphNode[] nodes;

    /**
     * 初始化图的顶点
     * @param vertexes
     * */
    public ListGraph(int[] vertexes) {
        nodes = new ListGraphNode[vertexes.length];
        for (int i = 0; i < vertexes.length; i++) {
            nodes[i] = new ListGraphNode(vertexes[i], null);
        }
    }

    /**
     * 添加 start 可到达的边
     * @param start 起始顶点
     * @param end 可到达顶点的数组
     * */
    public void addEdges(int start, int[] end) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].value == start) {
                ListGraphNode node = nodes[i];
                for (int j = 0; j < end.length; j++) {
                    node.next = new ListGraphNode(end[j], null);
                    node = node.next;
                }
            }
        }
    }

    /**
     * 打印出领接表数据
     * */
    public void printListGraph() {
        for (int i = 0; i < nodes.length; i++) {
            ListGraphNode node = nodes[i];
            do {
                System.out.print(node.value + " ");
                node = node.next;
            } while (node != null);
            System.out.println();
        }
    }
}