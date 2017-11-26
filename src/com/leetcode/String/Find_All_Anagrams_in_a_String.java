package com.leetcode.String;

// 438. Find All Anagrams in a String

import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) return result;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        int counter = map.size();
        int begin = 0, end = 0;


         while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            end++;

            while (counter == 0) {
                char tempc = s.charAt(begin);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (end - begin == p.length()) {
                    result.add(begin);
                }
                begin++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abasbauskwiokjsuwkbsaabbaab";
        String p = "aba";

        List<Integer> list = (new Find_All_Anagrams_in_a_String()).findAnagrams(s, p);

        for (Integer k : list) {
            System.out.print(k + " ");
        }
    }

}
