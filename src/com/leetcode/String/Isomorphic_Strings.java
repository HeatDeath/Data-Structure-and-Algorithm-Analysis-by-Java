package com.leetcode.String;

import java.util.HashMap;
import java.util.Map;


// 205. Isomorphic Strings


public class Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i))) // 两个字符映射到了同一个字符
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }else {
                if (!map.get(s.charAt(i)).equals(t.charAt(i)))  // 同一个字符映射到了不同字符
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
//        String s = "egg";
//        String t = "add";

//        String s = "paper";
//        String t = "title";

        String s = "foo";
        String t = "bar";

        System.out.print((new Isomorphic_Strings()).isIsomorphic(s, t));
    }
}
