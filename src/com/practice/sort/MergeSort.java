package com.practice.sort;

import java.util.Arrays;

public class MergeSort {
    private MergeSort() {
    }

    public static void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if (l >= r) return;
        int mid = (r - l) / 2 + l;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    private static void merge(Integer[] arr, int l, int mid, int r) {
        Integer[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] > aux[j - l]) {
                arr[k] = aux[j - l];
                j++;
            } else {
                arr[k] = aux[i - l];
                i++;
            }
        }
    }


    // 测试MergeSort
    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        MergeSort.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("-------------------------------------------");

        System.out.println("排序后的数组为：");
        SortTestHelper.printArray(arr);
        System.out.println("-------------------------------------------");

        System.out.println("排序后的数组是否有序：");
        if (SortTestHelper.isSorted(arr)) {
            System.out.println("数组有序~");
        } else {
            System.out.println("数组无序！");
        }
        System.out.println("-------------------------------------------");

        System.out.println("排序算法的运行时间为" + " : " + (end - start) + "ms");

    }
}
