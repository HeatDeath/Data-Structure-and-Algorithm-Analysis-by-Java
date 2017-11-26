package com.leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] str_arr = str.split(" ");

        if (pattern.length() != str_arr.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) // 在 map 中包含 pattern 的字符
                if (!map.get(pattern.charAt(i)).equals(str_arr[i])) // 但 pattern 中同一个字符
                                                                    // 以前 和 现在对应的 value 不同
                    return false;
            if (!map.containsKey(pattern.charAt(i)))    // 在 map 中不包含 pattern 的字符
                if (map.containsValue(str_arr[i]))  // 但 pattern 中不同的字符
                                                    // 却对应了相同的 value
                    return false;
            map.put(pattern.charAt(i), str_arr[i]);
        }

        return true;
    }


    public static void main(String[] args) {
        String str = "dog dog dog dog";
        String pattern = "abba";
        System.out.print((new Word_Pattern()).wordPattern(pattern, str));
    }

}
