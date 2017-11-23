package com.leetcode.array;

// 209 Minimum_Size_Subarray_Sum

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int minLength = nums.length + 1;
        while (l < nums.length) {
            if (r < nums.length - 1 && sum < s)
                sum += nums[++r];
            else
                sum -= nums[l++];
            if (sum >= s)
                minLength = Math.min(minLength, r - l + 1);
        }

        if (minLength == nums.length + 1)
            return 0;

        return minLength;

    }

//    public int minSubArrayLen(int s, int[] nums) {
//
//        int l = 0, r = -1; // nums[l...r]为我们的滑动窗口
//        int sum = 0;
//        int res = nums.length + 1;
//
//        while (l < nums.length) {   // 窗口的左边界在数组范围内,则循环继续
//
//            if (r < nums.length - 1 && sum < s) // r 还没到头 且 sum < s
//                sum += nums[++r];
//            else // r已经到头 或者 sum >= s
//                sum -= nums[l++];
//
//            if (sum >= s)
//                res = Math.min(res, r - l + 1);
//        }
//
//        if (res == nums.length + 1)
//            return 0;
//        return res;
//    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 8;
        System.out.println((new Minimum_Size_Subarray_Sum()).minSubArrayLen(s, nums));
    }

}
