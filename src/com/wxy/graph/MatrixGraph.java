package com.wxy.graph;

/**
 * Created by Kode on 2018/11/9.
 */
public class MatrixGraph {
    // 通过下标映射元素值
    private int[] mapping;
    //图的二维数组
    private int[][] matrix;

    /**
     * 初始化图的顶点
     * @param vertexes 顶点数组
     * */
    public MatrixGraph(int[] vertexes) {
        int length = vertexes.length;
        mapping = new int[length];
        matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            mapping[i] = vertexes[i];
        }
    }

    /**
     * 添加边
     * @param start
     * @param end
     * */
    public void addEdge(int start, int end) {
        int x = -1;
        int y = -1;
        //寻找坐标
        for (int i = 0; i < mapping.length; i++) {
            if (x != -1 && y != -1) {
                break;
            }
            if (start == mapping[i]) {
                x = i;
            }
            if (end == mapping[i]) {
                y = i;
            }
        }
        if (x == -1 || y == -1
                || x > mapping.length - 1 || y > mapping.length - 1) {
            throw new IndexOutOfBoundsException("边的顶点不存在");
        }
        matrix[x][y] = 1;
    }

    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
