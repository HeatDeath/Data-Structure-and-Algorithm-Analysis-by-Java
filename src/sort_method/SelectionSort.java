package sort_method;

public class SelectionSort {
	private SelectionSort() {
		// TODO Auto-generated constructor stub
	}
	
	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i <= n-1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
				
				swap(arr[i], arr[minIndex]);
				
			}
		}
	}
	
	public static void swap(Object i, Object j) {
		Object temp = i;
		i = j;
		j = temp;
	}
	
	public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(arr);
        for( int i = 0 ; i < arr.length ; i ++ ){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }
	
	
}
