package com.leetcode.array;

public class Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        int k = -1;
        int f = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (k == -1) {
                    k = i;
                    f = i;
                } else
                    f = i;
            }
        }
        int[] returnArr = {k, f};

        return returnArr;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 7, 7, 8, 8, 10};
//        int target = 8;
        int[] nums = {1};
        int target = 1;
        Search_for_a_Range search_for_a_range = new Search_for_a_Range();
        int[] result = search_for_a_range.searchRange(nums, target);
        for (int k : result)
            System.out.print(k + " ");

    }

}
