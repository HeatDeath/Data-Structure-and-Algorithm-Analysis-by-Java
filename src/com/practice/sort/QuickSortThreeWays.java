package com.practice.sort;

public class QuickSortThreeWays {
    private QuickSortThreeWays() {
    }

    public static void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l + 1) + l));
        Integer temp = arr[l];
        // arr[l+1...lt] < temp
        // arr[lt+1...i-1] == temp
        // arr[gt...r] > temp
        int i = l + 1, lt = l, gt = r + 1;
        while (i < gt) {
            if (arr[i] < temp) {
                lt++;
                SortTestHelper.swap(arr, i, lt);
                i++;
            } else if (arr[i] > temp) {
                gt--;
                SortTestHelper.swap(arr, i, gt);
            } else { // arr[i] == temp
                i++;
            }
        }
        SortTestHelper.swap(arr, l, lt);
        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }

    public static void main(String[] args) {
        int N = 800000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        QuickSortThreeWays.sort(arr);
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
