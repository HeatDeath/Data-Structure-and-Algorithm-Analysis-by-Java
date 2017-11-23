package com.practice.search;

import com.leetcode.Helper;

// 二分查找的前提是数组为有序数组！！！

public class BinarySearch {
    private BinarySearch() {
    }

    public static int search(int[] arr, int target) {
        int n = arr.length;
        return search(arr, 0, n - 1, target);
    }

    private static int search(int[] arr, int l, int r, int target) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            return search(arr, mid + 1, r, target);
        else
            return search(arr, l, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] arr = Helper.generateRandomArray(10, 0, 100);
        Helper.printArray(arr);
        System.out.println();
//        int target = arr[(int) (Math.random() * 10)];
        int target = arr[1];
        System.out.println(target);
        int result = BinarySearch.search(arr, target);
        System.out.println(result);
    }

}
