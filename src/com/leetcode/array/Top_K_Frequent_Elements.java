package com.leetcode.array;

import java.util.*;

public class Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用 map 统计 nums 中数字出现的频数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 根据数字出现的频数，将 map 中的 key 丢进 桶中 bucket
        // bucket[] 的下标表示 key 出现的频数
        Set<Integer>[] bucket = new HashSet[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new HashSet<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        // 将 前 k 大的数组放入 result 中
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Integer num: bucket[i]){
                    if (count >= k)
                        break;
                    result.add(num);
                    count++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 2, 2, 3, 1, 1, 1, 1, 1, 2, 2, 2, 2, 6, 5, 4, 43, 23, 2, 2, 1, 23, 2, 2, 1, 3, 2};
//        int[] arr ={1};   // 注意桶的大小
//        int k = 1;

        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        // -1 2 1 3 4  输出错误！应该还是 -1,2

        List<Integer> result = (new Top_K_Frequent_Elements()).topKFrequent(arr, k);
        for (Integer num : result)
            System.out.print(num + " ");
    }
}
