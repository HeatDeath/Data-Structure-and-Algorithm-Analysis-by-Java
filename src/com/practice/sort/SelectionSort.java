package com.practice.sort;
/*
* 算法思想：
*   重复（元素个数-1）次
*       把第一个没有排序过的元素设置为最小值
*       遍历每个没有排序过的元素
*           如果元素 < 现在的最小值
*           将此元素设置成为新的最小值
*       将最小值和第一个没有排序过的位置交换
*
* */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(arr, minIndex, i);
        }
    }

    public static void main(String[] args) {
        int N = 20;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        SelectionSort.sort(arr);
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
