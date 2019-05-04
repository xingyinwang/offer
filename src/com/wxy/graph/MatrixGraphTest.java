package com.wxy.graph;

/**
 * Created by Kode on 2018/11/9.
 */
public class MatrixGraphTest {
    public static void main(String[] args) {
        int[] vertexes = new int[]{0, 1, 2, 3};
        MatrixGraph graph = new MatrixGraph(vertexes);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(3,2);
        graph.printMatrix();

        ListGraph listGraph = new ListGraph(vertexes);
        listGraph.addEdges(0, new int[]{1, 2, 3});
        listGraph.addEdges(1, new int[]{2});
        listGraph.addEdges(3, new int[]{2});
        listGraph.printListGraph();
    }
}
