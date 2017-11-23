package com.leetcode;

public class Helper {
    private Helper() {
    }

    public static int[] generateRandomArray(int arr_length, int l, int r) {
        int[] arr = new int[arr_length];
        for (int i = 0; i < arr_length; i++) {
            arr[i] = (int) (Math.random() * (r - l + 1) + l);
        }
        return arr;
    }

    public static void printArray(int[] arr){
        for (int k : arr)
            System.out.print(k + " ");
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
