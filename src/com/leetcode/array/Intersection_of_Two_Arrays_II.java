package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> map_1 = new HashMap<>();
        for (int num : nums1)
            map_1.put(num, map_1.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map_1.containsKey(num)){
                if (map_1.get(num) <= 0)
                    continue;
                list.add(num);
                map_1.put(num, map_1.get(num)-1);
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer num:list)
            result[i++] = num;
        return result;
    }
//    public int[] intersect(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 || nums2.length == 0)
//            return new int[0];
//
//        Map<Integer, Integer> map_1 = new HashMap<>();
//        for (int num : nums1)
//            map_1.put(num, map_1.getOrDefault(num, 0) + 1);
//
//        Map<Integer, Integer> map_2 = new HashMap<>();
//        for (int num : nums2)
//            map_2.put(num, map_2.getOrDefault(num, 0) + 1);
//
//        Map<Integer, Integer> map_3 = new HashMap<>();
//        for (Integer num : map_1.keySet())
//            if (map_2.containsKey(num))
//                map_3.put(num, Math.min(map_1.get(num), map_2.get(num)));
//        int size = 0;
//        for (Integer count : map_3.values())
//            size += count;
//
//        int[] result = new int[size];
//        int i = 0;
//        for (Integer num : map_3.keySet()) {
//            int count = map_3.get(num);
//            while (count != 0) {
//                result[i++] = num;
//                count--;
//            }
//        }
//
//        return result;
//
//    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1, 3, 3, 4, 3, 2, 4, 2, 5, 3, 2, 1, 3, 2, 1, 2, 0};
        int[] nums2 = {2, 2, 3, 1, 32, 21, 1, 1, 1, 1, 3, 12};
        int[] result = (new Intersection_of_Two_Arrays_II()).intersect(nums1, nums2);
        for (int num : result)
            System.out.print(num + " ");
    }
}
