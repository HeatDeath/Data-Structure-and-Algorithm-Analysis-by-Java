package com.leetcode.array;

import java.util.Arrays;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1)
            return 0;
        if (height.length == 2)
            return height[0] > height[1] ? height[1] : height[0];

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j])
                j--;
            else
                i++;
        }
        return maxArea;
    }

    // 题意理解错误！！！ 不仅是两个边的高度，还要考虑 x 轴方向上的长度！！
    // 所以应该用双指针对撞方式求解
//    public int maxArea(int[] height) {
//        if (height == null || height.length == 0 || height.length == 1)
//            return 0;
//        if (height.length == 2)
//            return height[0] > height[1] ? height[1] : height[0];
//
//        int target = 1;
//        return solve(height, 0, height.length - 1, target);
//    }
//
//    public int solve(int[] arr, int l, int r, int target) {
//        int p = partition(arr, l, r);
//        if (p > target)
//            return solve(arr, l, p - 1, target);
//        else if (p < target)
//            return solve(arr, p + 1, r, target);
//        else
//            return arr[p];
//
//    }
//
//    public int partition(int[] arr, int l, int r) {
//        swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
//        int temp = arr[l];
//        int i = l + 1, j = l;
//        for (; i <= r; i++) {
//            if (arr[i] > temp)
//                swap(arr, i, ++j);
//        }
//        swap(arr, l, j);
//        return j;
//    }
//
//    public void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

    public static void main(String[] args) {
        Container_With_Most_Water container_with_most_water = new Container_With_Most_Water();

        int[] height = {1, 2, 3, 2, 2, 2, 3, 45, 6, 4, 3, 3, 2, 43, 5, 3, 2};

//        int[] height = {1, 2, 3};


        System.out.println(container_with_most_water.maxArea(height));

    }

}
