package com.leetcode.array;

// 349. Intersection of Two Arrays

import java.util.*;

public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];

        Set<Integer> set_1 = new HashSet<>();
        for (int num : nums1)
            set_1.add(num);

        Set<Integer> set_2 = new HashSet<>();
        for (int num : nums2)
            if (set_1.contains(num))
                set_2.add(num);

        int[] result = new int[set_2.size()];
        int i = 0;
        for (Integer num : set_2)
            result[i++] = num;

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = (new Intersection_of_Two_Arrays()).intersection(nums1, nums2);

        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }

}
