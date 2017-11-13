package com.algorithm.sort;

public class HeapSortInPlace {
    private HeapSortInPlace() {
    }

    public static void sort(Integer[] arr) {
        int n = arr.length;

        // 注意：我们堆的索引是从0开始的
        // 从（最后一个元素的索引-1）/2 开始
        // 最后一个元素的索引为 n-1

        // 将数组原地 shiftDown 变为 最大堆
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        // 交换数组的第一个元素（最大元素）与数组末尾的元素（i）
        // 使整个数组从后向前依次有序
        // 对剩余的数组进行 shiftDown 操作，使其变为 最大堆
        for (int i = n - 1; i > 0; i--) {
            SortTestHelper.swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(Integer[] arr, int n, int k) {
        // 当存在 左子节点 时
        while (2 * k + 1 < n) {

            // j 为 左子节点
            int j = 2 * k + 1;

            // 右子节点（j+1）存在，且 右子节点 > 左子节点
            if (j + 1 < n && arr[j + 1].compareTo(arr[j]) > 0) {
                // j 移动到 右子节点处
                j++;
            }

            // 父节点（k） > 子节点中较大者, break
            if (arr[k].compareTo(arr[j]) >= 0) break;

            // 父节点（k） 与 子节点中较大者进行交换
            SortTestHelper.swap(arr, j, k);

            // k 移动到 子节点中 较大者 的位置（j）
            k = j;
        }
    }

    public static void main(String[] args) {
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        HeapSortInPlace.sort(arr);
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
