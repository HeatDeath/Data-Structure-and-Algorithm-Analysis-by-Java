package com.algorithm.sort;

import java.lang.reflect.Method;

public class SortTestHelper {
	// SortTestHelper 不允许产生任何实例
	private SortTestHelper() {
	}

	// 生成有 n 个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
	public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; i++)
			arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
		return arr;
	}

	// 打印 arr 数组的所有内容
	public static void printArray(Object[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();

		return;
	}

	// 判断 arr 数组是否有序（从小到大排列）
	public static boolean isSorted(Integer[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}

	// 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
	public static void testSort(String sortClassName, Integer[] arr) {

		// 通过Java的反射机制，通过排序的类名，运行排序函数

		try {
			// 通过sortClassName获得排序函数的Class对象
			Class sortClass = Class.forName(sortClassName);

			// 通过排序函数的Class对象获得排序方法
			Method sortMethod = sortClass.getMethod("sort", new Class[] { Integer[].class });

			// 排序参数只有一个，是可比较数组arr
			Object[] params = new Object[] { arr };

			long startTime = System.currentTimeMillis();
			// 调用排序函数
			sortMethod.invoke(null, params);
			long endTime = System.currentTimeMillis();

			// 检验结果的正确性
			if (isSorted(arr)) {
				System.out.println("排序后的数组为有序数组");
			}

			// 输出测试的排序算法的运行时间
			System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void swap(Integer[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 单元测试
	public static void main(String[] args) {
		// printArray(generateRandomArray(100, 100, 200));
		//
		// if (isSorted(generateRandomArray(100, 100, 200))) {
		// System.out.println("测试数组有序");
		// }
		// else {
		// System.out.println("测试数组无序");
		// }
		
		int N = 5000;
	    
	        
		testSort("com.algorithm.sort.SelectionSort", generateRandomArray(N, 0, 100000));
		testSort("com.algorithm.sort.InsertionSort", generateRandomArray(N, 0, 100000));

	}
}
