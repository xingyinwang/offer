package com.wxy.leetCode;

/**
 * Created by Cser_W on 2018/6/26.
 */
public class 直方图中的最大矩形 {
    public static void main(String[] args){
        int[] arr = new int[]{2,1,5,6,2,3};
        int area = largestRectangleArea(arr);
        System.out.println(area);
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int width = 0;
        int minHeights = 0;
        for (int i = 0; i < heights.length; ++i) {
            minHeights = heights[i];
            width = 0;
            for (int j = i; j < heights.length; ++j) {
                width ++;
                minHeights = Math.min(minHeights, heights[j]);
                maxArea = Math.max(maxArea, width * minHeights);
            }
        }
        return maxArea;
    }
}
