package com.algorithm.sort;

import com.dataStructure.heap.MaxHeap;

public class HeapSortHeapify {
    private HeapSortHeapify() {
    }

    // 对整个arr数组使用 HeapSortHeapify 排序
    // HeapSortHeapify, 借助我们的heapify过程创建堆
    // 此时, 创建堆的过程时间复杂度为O(n), 将所有元素依次从堆中取出来, 实践复杂度为O(nlogn)
    // 堆排序的总体时间复杂度依然是O(nlogn), 但是比HeapSort1性能更优, 因为创建堆的性能更优
    public static void sort(Integer[] arr) {
        int n = arr.length;
        MaxHeap maxHeap = new MaxHeap(arr);

        for (int i = n - 1; i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args){
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        HeapSortHeapify.sort(arr);
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
