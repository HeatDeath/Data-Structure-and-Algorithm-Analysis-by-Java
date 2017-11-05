package com.algorithm.sort;

public class QuickSort {
    private QuickSort(){}

    public static void sort(Integer[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    public static void sort(Integer[] arr, int l, int r){
        if (l >= r){
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition(Integer[] arr, int l, int r){
        Integer temp = arr[l];

        int j = l;
        for(int i = l + 1; i <= r; i++){
            if (arr[i].compareTo(temp) < 0){
                j++;
                SortTestHelper.swap(arr, i, j);
            }
        }
        SortTestHelper.swap(arr, j, l);
        return j;
    }

    public static void main(String[] args){
        int N = 8;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        QuickSort.sort(arr);
        Long end = System.currentTimeMillis();
        System.out.println("-------------------------------------------");

        System.out.println("排序后的数组为：");
        SortTestHelper.printArray(arr);
        System.out.println("-------------------------------------------");

        System.out.println("排序后的数组是否有序：");
        if (SortTestHelper.isSorted(arr)){
            System.out.println("数组有序~");
        } else {
            System.out.println("数组无序！");
        }
        System.out.println("-------------------------------------------");

        System.out.println( "排序算法的运行时间为"+ " : " + (end-start) + "ms" );

    }
}
