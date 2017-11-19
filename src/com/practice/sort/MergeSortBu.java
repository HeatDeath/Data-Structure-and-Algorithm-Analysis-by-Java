package com.practice.sort;

import java.util.Arrays;

public class MergeSortBu {
    private MergeSortBu() {
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

    public static void sort(Integer[] arr) {
        int n = arr.length;
//        for (int size = 1; size < n; size += size) {
//            for (int i = 0; i < n - size; i += 2 * size) {
//                if (arr[i+size-1] > arr[i+size])
//                    merge(arr,i, i+size-1, Math.min(i+2*size-1, n-1));
//            }
//        }

        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(i + 15, n - 1));
        }

        for (int size = 16; size < n; size += size) {
            for (int i = 0; i < n - size; i+= 2*size) {
                if (arr[i + size - 1] > arr[i + size])
                    merge(arr, i, i + size - 1, Math.min(n - 1, i + 2 * size - 1));
            }
        }
    }

    // 测试MergeSort
    public static void main(String[] args) {
        int N = 80000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        MergeSortBu.sort(arr);
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
