package com.leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();  // 辅助的哈希表
        int max = 0;
        for (int r = 0, l = 0; r < s.length(); ++r) {
            if (map.containsKey(s.charAt(r))) { // 当出现重复元素时
                l = Math.max(l, map.get(s.charAt(r)) + 1);  // 将 l 移动到 max(l当前位置， 上一次该元素出现的位置+1)
            }
            map.put(s.charAt(r), r);    // 将首次出现的元素放入 map 中，或是更新此元素的索引
            max = Math.max(max, r - l + 1); // 更新 max
        }
        return max;
    }


    public static void main(String[] args) {
//        int[] freq = new int[256];
//        char ch = 'a';
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
//        System.out.println((char)96);
//
//        for (int i = 0 ; i < 256;i++){
//            System.out.println(i + "-" + (char)i);
//        }
    }

}
