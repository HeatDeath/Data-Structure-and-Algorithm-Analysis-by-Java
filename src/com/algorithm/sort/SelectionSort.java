package com.algorithm.sort;

public class SelectionSort {
	// 我们的算法类不允许产生任何实例
	private SelectionSort() {
	}

	public static void sort(Integer[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++){
			int minIndex = i;
			for (int j = i + 1; j < n; j++){
				if (arr[j].compareTo(arr[minIndex]) < 0){
					minIndex = j;
				}
			}
			SortTestHelper.swap(arr, i ,minIndex);
		}

	}


	// 单元测试
	public static void main(String[] args) {
		int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        SelectionSort.sort(arr);
		System.out.println("-------------------------------------------");

		System.out.println("排序后的数组为：");
		SortTestHelper.printArray(arr);
		System.out.println("-------------------------------------------");

		System.out.println("排序后的数组是否有序：");
		if (SortTestHelper.isSorted(arr)){
			System.out.println("数组有序");
		} else {
			System.out.println("数组无序！");
		}
		System.out.println("-------------------------------------------");
	}

}
