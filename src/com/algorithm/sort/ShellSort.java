package com.algorithm.sort;

public class ShellSort {

    private ShellSort(){}

    public static void sort(Integer[] arr){
        int n = arr.length;
        int h = 1;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        while (h < n/3){
            h = h * 3 + 1;
        }

        while (h >= 1) {

            // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
            for (int i = h; i < n; i++) {
                Integer temp = arr[i];
                int j = i;
                for (; j >= h; j = j - h) {
                    if (arr[j - h].compareTo(temp) > 0) {
                        arr[j] = arr[j - h];
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
            h /= 3;
        }
    }

    // 单元测试
    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);

        System.out.println("排序前的数组为：");
        SortTestHelper.printArray(arr);
        Long start = System.currentTimeMillis();
        ShellSort.sort(arr);
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
