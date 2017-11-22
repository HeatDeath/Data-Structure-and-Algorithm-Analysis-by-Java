package com.leetcode.array;

// 26 RemoveDuplicates

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
//        int n = nums.length;
//        int k = 0;  // nums[0...k] 为非重复的元素      nums(k...i) 为重复元素
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != nums[k]) {
//                nums[++k] = nums[i];
//            }
//        }
//        return k + 1;

        int k = 0;  // nums[0...k） 元素非重复
        for (int num : nums)
            if (k < 1 || num > nums[k - 1])
                nums[k++] = num;
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 6};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates(nums));
        for (int num : nums)
            System.out.print(num + " ");
    }
}
