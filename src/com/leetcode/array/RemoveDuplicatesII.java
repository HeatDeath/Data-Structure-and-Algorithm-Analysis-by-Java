package com.leetcode.array;

public class RemoveDuplicatesII {

    public int removeDuplicatesII(int[] nums) {
//        int n = nums.length;
//        int k = 0;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] != nums[k]) {
//                nums[++k] = nums[i];
//                count = 1;
//            } else if (nums[i] == nums[k] && count == 0) {
//                count++;
//            } else if (nums[i] == nums[k] && count < 2) {
//                nums[++k] = nums[i];
//                count++;
//            }
//        }
//        return k + 1;

        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;

    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 1, 2, 3, 4, 4, 4, 4, 6};
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4};
//        int[] nums = {};
        RemoveDuplicatesII removeDuplicates = new RemoveDuplicatesII();
        System.out.println(removeDuplicates.removeDuplicatesII(nums));
        for (int num : nums)
            System.out.print(num + "");
    }
}
