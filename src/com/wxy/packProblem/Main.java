package com.wxy.packProblem;

/**
 * Created by Cser_W on 2018/3/29.
 */

import java.util.Scanner;
public class Main {
    public static int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int len = 3;
        int[][] array = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                array[i][j] = in.nextInt();
            }
        }
        int [][]temp=change(array);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
                System.out.print(temp[i][j]+"\t");
            }
            System.out.println();
        }
    }
}