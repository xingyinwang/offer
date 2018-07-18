package com.wxy.leetCode;

/**
 * Created by Cser_W on 2018/6/30.
 */
public class 找单词回溯法 {
    public static void main(String[] args){
        char[][]  board = new char[][]{{'a'}};
        String word = "ab";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (existHelper(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean existHelper(char[][] board, int row, int col,
                                String word, int index, boolean[][] visited) {
        if (index >= word.length()) {
            return true;
        }
        if(row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean res = existHelper(board, row - 1, col, word, index + 1, visited)
                || existHelper(board, row + 1, col, word, index + 1, visited)
                || existHelper(board, row, col - 1, word, index + 1, visited)
                || existHelper(board, row, col + 1, word, index + 1, visited);
        visited[row][col] = false;
        return res;
    }
}
