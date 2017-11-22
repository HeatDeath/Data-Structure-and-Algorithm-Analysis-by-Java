package com.leetcode.sort;

public class SortColors {
    // 使用 计数排序
//    public void sortColors(int[] nums) {
//        int[] count = {0, 0, 0};
//        for (int num : nums)
//            count[num]++;
//        int index = 0;
//        int k = 0;
//        for (int n : count) {
//            while (n != 0) {
//                nums[index++] = k;
//                n--;
//            }
//            k++;
//        }
//    }
    // 使用 快速排序的三向切分思想
    public void sortColors(int[] nums) {
        // 假设在 nums[] 的最前端加上一个 nums[-1] = 1
        int lt = -1, i = 0, gt = nums.length;    // [0...lt] == 0  [gt...n-1] == 2
        while (i < gt) {
            if (nums[i] == 0)
                swap(nums, i++, ++lt);
            else if (nums[i] == 1)
                i++;
            else // nums[i] == 2
                swap(nums, i, --gt);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0};
        int[] nums = {2, 1};
        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }


}
