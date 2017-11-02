package com.algorithm.sort;


public class BubbleSort {
	private BubbleSort() {

	}

	public static void sort(Integer[] arr) {
		int n = arr.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (arr[i] < arr[i-1]) {
					SortTestHelper.swap(arr, i-1, i);
					swapped = true;
				}
			}

			// 优化, 每一趟Bubble Sort都将最大的元素放在了最后的位置
            // 所以下一次排序, 最后的元素可以不再考虑
			n--;
		}while(swapped);
	}

	// 单元测试
	public static void main(String[] args) {
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

		System.out.println("排序前的数组为：");
		SortTestHelper.printArray(arr);
		Long start = System.currentTimeMillis();
		BubbleSort.sort(arr);
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
