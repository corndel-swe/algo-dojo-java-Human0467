package com.corndel.two_pointers.max_water_container;

public class MaxWaterContainer {

    public static int mostWaterBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int width = j - i;
                int currentHeight = Math.min(heights[i], heights[j]);
                int currentArea = width * currentHeight;
                if (currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
        return maxArea;
    }


    public static int mostWaterTwoPointers(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right){
            int width = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);
            int currentArea = width * currentHeight;
            if (currentArea > maxArea){
                maxArea = currentArea;
            }
            if (heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
