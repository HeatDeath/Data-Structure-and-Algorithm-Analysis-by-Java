package com.leetcode.String;

// 125 Valid_Palindrome

// 题目要求的是字母或是数字！！！
// 字符串为空算是回文串

public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()){
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        char ch_1, ch_2;
        while (i <= j) {
            ch_1 = s.charAt(i);
            ch_2 = s.charAt(j);
            if (Character.isLetterOrDigit(ch_1) && Character.isLetterOrDigit(ch_2)) {
                if (Character.toLowerCase(ch_1) == Character.toLowerCase(ch_2)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (Character.isLetterOrDigit(ch_1)) {
                j--;
            } else {
                i++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Valid_Palindrome valid_palindrome = new Valid_Palindrome();
        System.out.println(valid_palindrome.isPalindrome(s));

        String k = "race a car";
        System.out.println(valid_palindrome.isPalindrome(k));

        String f = "0P";
        System.out.println(valid_palindrome.isPalindrome(f));

    }

}
