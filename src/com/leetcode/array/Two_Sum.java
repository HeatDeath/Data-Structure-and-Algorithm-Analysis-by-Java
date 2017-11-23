package com.leetcode.array;

// 1 Two_Sum

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    // O(n^2)
//    public int[] twoSum(int[] nums, int target) {
//
//        int start = -1;
//        int end = - 1;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++){
//                if (nums[i] + nums[j] == target){
//                    start = i;
//                    end =j;
//                    break;
//                }
//            }
//        }
//
//        return new int[]{start, end};
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();    // 使用 哈希表 作为辅助的数据结构
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if (map.get(nums[i]) != null){
                result[0] = map.get(nums[i]);
                result[1] = i;
            }else {
                map.put(diff, i);
            }
        }
        return result;
    }


    public static void main(String[] args) {


        int[] numbers = {3, 2, 4};
        int target = 6;

        Two_Sum two_sum = new Two_Sum();
        int[] result = two_sum.twoSum(numbers, target);
        for (int k : result)
            System.out.print(k + " ");
    }
}
