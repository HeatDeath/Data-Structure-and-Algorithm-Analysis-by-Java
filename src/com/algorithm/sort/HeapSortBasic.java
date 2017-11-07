package com.algorithm.sort;

import com.dataStructure.heap.MaxHeap;

public class HeapSortBasic {
    private HeapSortBasic() {
    }

    // 对整个arr数组使用 HeapSortBasic 排序
    // HeapSortBasic, 将所有的元素依次添加到堆中, 在将所有元素从堆中依次取出来, 即完成了排序
    // 无论是创建堆的过程, 还是从堆中依次取出元素的过程, 时间复杂度均为O(nlogn)
    // 整个堆排序的整体时间复杂度为O(nlogn)
    public static void sort(Integer[] arr) {
        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(n);

        // 将 arr 中的元素依次取出，插入最大堆中
        for (Integer num: arr){
            maxHeap.insert(num);
        }

        // 取出最大堆中最大的元素，赋值给 arr 中的最后一个元素
        for (int i = n-1; i>=0; i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String [] args){
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        HeapSortBasic.sort(arr);
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
