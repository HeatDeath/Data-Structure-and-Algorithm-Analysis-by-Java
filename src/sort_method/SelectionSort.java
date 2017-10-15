package sort_method;

public class SelectionSort {
	// 我们的算法类不允许产生任何实例
	private SelectionSort() {
	}

	public static void sort(Integer[] arr) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			// 寻找[i, n)区间里的最小值的索引
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			SortTestHelper.swap(arr, i, minIndex);
		}
	}


	// 单元测试
	public static void main(String[] args) {
		int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("sort_method.SelectionSort", arr);
	}

}
