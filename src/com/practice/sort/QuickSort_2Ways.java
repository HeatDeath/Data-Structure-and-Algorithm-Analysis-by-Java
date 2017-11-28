package com.practice.sort;

public class QuickSort_2Ways {
    private QuickSort_2Ways() {
    }

    public static void sort(Integer[] arr) {
        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if (l >= r) return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    private static int partition(Integer[] arr, int l, int r) {
        SortTestHelper.swap(arr, l, (int) (Math.random() * (r - l) + l));
        Integer temp = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < temp)
                i++;
            while (j >= l + 1 && arr[j] > temp)
                j--;
            if (i > j)
                break;
            SortTestHelper.swap(arr, i, j);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int N = 800000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        QuickSort_2Ways.sort(arr);
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
