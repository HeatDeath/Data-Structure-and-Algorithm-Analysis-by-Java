package com.leetcode.array;

// 283 MoveZeroes

public class MoveZeroes {
    // version-1 时间复杂度 O(n) , 空间复杂度 O(n)
//    public static int[] moveZeroes(int[] nums) {
//        int n = nums.length;
//        int[] aux = new int[n];
//        int k = 0;
//        for (int i = 0; i < n; i++)
//            if (nums[i] != 0)
//                aux[k++] = nums[i];
//        while (k < n)
//            aux[k++] = 0;
//        return aux;
//    }

    // version-2 时间复杂度 O(n)，空间复杂度 O(1)
//    public static void moveZeroes(int[] nums) {
//        int n = nums.length;
//        int k = 0;  // nums[0...k) != 0     nums[k...i) == 0
//        for (int i = 0; i < n; i++)
//            if (nums[i] != 0)
//                if (i != k) // 防止整个数组全部是非0元素
//                    swap(nums, i, k++);
//                else
//                    k++;
//
//    }

    public static void moveZeroes(int[] nums) {
//        int n = nums.length;
//        int k = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != 0)
//                nums[k++] = nums[i];
//        }
//        while (k < n)
//            nums[k++] = 0;

        int k = 0;
        for (int num:nums)
            if (num > 0)
                nums[k++] = num;
        while (k<nums.length)
            nums[k++] = 0;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {2, 1};

//        int[] aux = MoveZeroes.moveZeroes(nums);
        MoveZeroes.moveZeroes(nums);
        for (int num : nums)
            System.out.println(num);
    }

}
