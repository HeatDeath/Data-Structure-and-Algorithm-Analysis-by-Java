package com.leetcode.array;

// 209 Minimum_Size_Subarray_Sum

public class Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int l = 0, r = 0, sum = 0, minLength = Integer.MAX_VALUE;
        while (r < nums.length) {   // 当 r 指针未越界
            sum += nums[r++];   // sum 加上滑动窗口最右侧的元素， r 指针右移
            while (sum >= s) {  // 当 sum >= s
                minLength = Math.min(minLength, r-l); // 更新 minLength
                sum -= nums[l++];   // sum 去掉滑动窗口的最左侧元素， l 指针右移
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;

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
        int s = 5;
        System.out.println((new Minimum_Size_Subarray_Sum()).minSubArrayLen(s, nums));
    }

}
