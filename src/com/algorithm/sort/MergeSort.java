package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort{

    // 我们的算法类不允许产生任何实例
    private MergeSort(){}

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

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(Integer[] arr, int l, int r) {

//        if (l >= r)
//            return;

        // 优化2: 对于小规模数组, 使用插入排序
        if (r - l < 15){
            InsertionSort.sort(arr);
            return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if (arr[mid] > arr[mid+1]) {
            merge(arr, l, mid, r);
        }
    }

    public static void sort(Integer[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }



    // 测试MergeSort
    public static void main(String[] args) {
        int N = 8;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

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
        if (SortTestHelper.isSorted(arr)){
            System.out.println("数组有序~");
        } else {
            System.out.println("数组无序！");
        }
        System.out.println("-------------------------------------------");

        System.out.println( "排序算法的运行时间为"+ " : " + (end-start) + "ms" );

    }
}
