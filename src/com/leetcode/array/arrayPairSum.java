package com.leetcode.array;

import java.util.Arrays;
class arrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i += 2) {
        	sum += nums[i];
        }
        return sum;
    }
}
