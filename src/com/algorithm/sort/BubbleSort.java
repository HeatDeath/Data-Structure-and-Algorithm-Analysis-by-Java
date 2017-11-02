package com.algorithm.sort;

public class BubbleSort {
	private BubbleSort() {

	}

	public static void sort(Integer[] arr) {
		int n = arr.length;
		boolean swapped = false;
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
		int N = 20;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000);
		SortTestHelper.testSort("com.algorithm.sort.BubbleSort", arr);
//		SortTestHelper.printArray(arr);
//		System.out.println("---------------------------------");
//		BubbleSort.sort(arr);
//		SortTestHelper.printArray(arr);
//		SortTestHelper.isSorted(arr);
	}
}
