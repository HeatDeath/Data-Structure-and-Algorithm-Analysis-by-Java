package com.algorithm.sort;

public class InsertionSort {
    private InsertionSort() {
    }



	public static void sort(Integer[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j].compareTo(arr[j - 1]) < 0) {
					 SortTestHelper.swap(arr, j-1, j);
				}
				else {
					break;
				}
			}

		}
	}

    // 优化
    // 使用赋值替代交换
//    public static void sort(Integer[] arr) {
//        int n = arr.length;
//        for (int i = 1; i < n; i++) {
//            Integer temp = arr[i];
//            int j = i;
//            for (; j > 0; j--) {
//                if (arr[j - 1].compareTo(temp) > 0) {
//                    arr[j] = arr[j - 1];
//
//                    // 对于【近乎有序】的数组，【插入排序】的性能【更优】
//                    // 因为此处跳出循环
//                } else {
//                    break;
//                }
//            }
//            arr[j] = temp;
//        }
//    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Integer[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Integer temp = arr[i];
            int j = i;
            for (; j > l; j--)
                if (arr[j - 1].compareTo(temp) > 0) {
                    arr[j] = arr[j - 1];
                }else {
                    break;
                }
            arr[j] = temp;
        }
    }

    // 单元测试
    public static void main(String[] args) {
        int N = 10000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        InsertionSort.sort(arr);
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

    }

}
