package com.leetcode.array;

// 27 RemoveElement

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
//        int n = nums.length;
//        int k = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != val)
//                nums[k++] = nums[i];
//        }
//        return k;

        int k = 0;
        for (int num : nums)
            if (num != val)
                nums[k++] = num;
        return k;
    }

}
