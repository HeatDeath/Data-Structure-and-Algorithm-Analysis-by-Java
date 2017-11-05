package com.algorithm.sort;

import java.util.Arrays;

public class MergeSortBU {
    private MergeSortBU(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Integer[] arr, int l, int mid, int r) {

        Integer[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l].compareTo(aux[j-l]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }

    public static void sort(Integer[] arr){
        int n = arr.length;

//        // Merge Sort Bottom Up 无优化版本
//        for (int size = 1; size < n; size *= 2){
//            for (int i = 0; i < n - size; i += size*2){
//                merge(arr, i, i + size - 1, Math.min(n-1, i+2*size-1));
//            }
//        }

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSort.sort(arr, i, Math.min(i+15, n-1));

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
    }

    public static void main(String[] args){
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        MergeSortBU.sort(arr);
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
