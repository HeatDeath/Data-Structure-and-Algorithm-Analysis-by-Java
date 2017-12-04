package com.practice.sort;

public class InsertionSort {
    private InsertionSort() {
    }

//    public static void sort(Integer[] arr) {
//        int n = arr.length;
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j - 1] > arr[j]){
//                    SortTestHelper.swap(arr, j-1, j);
//                }
//                else {
//                    break;
//                }
//            }
//        }
//    }

    public static void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[j]>arr[j-1]){
                    SortTestHelper.swap(arr,j-1,j);
                }else {
                    break;
                }
            }
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Integer[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Integer temp = arr[i];
            int j = i;
            for (; j > l; j--)
                if (arr[j - 1].compareTo(temp) > 0) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        InsertionSort.sort(arr);
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
