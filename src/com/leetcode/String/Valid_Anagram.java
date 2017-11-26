package com.leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        if (s.length() == 0 && t.length() == 0)
            return true;

        Map<Character, Integer> map_1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map_1.put(s.charAt(i), map_1.getOrDefault(s.charAt(i), 0) + 1);

        for (int i = 0; i < t.length(); i++)
            if (map_1.containsKey(t.charAt(i)))
                map_1.put(t.charAt(i), map_1.get(t.charAt(i)) - 1);
            else
                return false;

        for (Integer count : map_1.values())
            if (count != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
//        String s = "anagram";
//        String t =  "nagaram";
//        String s = "rat";
//        String t =  "car";

        String s = "";
        String t = "";
        boolean result = (new Valid_Anagram()).isAnagram(s, t);
        System.out.print(result + " ");
    }
}
