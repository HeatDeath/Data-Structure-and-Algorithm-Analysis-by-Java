package com.algorithm.sort;

public class InsertionSort {
	private InsertionSort() {
	};

	public static void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {

			// 寻找元素 arr[i] 合适的插入位置
//			for (int j = i; j > 0; j--) {
//				if (arr[j].compareTo(arr[j - 1]) < 0) {
//					 SortTestHelper.swap(arr, j-1, j);
//				}
//				else {
//					break;
//				}
//			}
			
			Integer temp = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(temp) > 0 ; j--)
                arr[j] = arr[j-1];
            arr[j] = temp;
		}
	}

	// 单元测试
	public static void main(String[] args) {
		int N = 20000;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 100, 100000);
		SortTestHelper.testSort("sort_method.InsertionSort", arr);
	}

}
