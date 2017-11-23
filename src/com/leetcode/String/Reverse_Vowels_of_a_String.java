package com.leetcode.String;

// 345. Reverse Vowels of a String

import java.util.Arrays;
import java.util.List;

public class Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s.isEmpty() || s.length() == 1)
            return s;

        // 应该考虑大小写问题！
        Character[] vowel_arr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        List<Character> vowel_list = Arrays.asList(vowel_arr);
        StringBuilder strBuilder = new StringBuilder(s);

        int i = 0;
        int j = s.length() - 1;
        char ch_1, ch_2;
        while (i <= j) {
            ch_1 = s.charAt(i);
            ch_2 = s.charAt(j);
            if (vowel_list.contains(ch_1) && vowel_list.contains(ch_2)){
                strBuilder.setCharAt(i, s.charAt(j));
                strBuilder.setCharAt(j, s.charAt(i));
                i++;
                j--;
            }else if (vowel_list.contains(ch_1)){
                j--;
            }else {
                i++;
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args){
        Reverse_Vowels_of_a_String reverse_vowels_of_a_string = new Reverse_Vowels_of_a_String();

        String str =  "hello";
        System.out.println(reverse_vowels_of_a_string.reverseVowels(str));

        String str_1 = "leetcode";
        System.out.println(reverse_vowels_of_a_string.reverseVowels(str_1));


    }

}
