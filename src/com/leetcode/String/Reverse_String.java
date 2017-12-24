package com.leetcode.String;

//  344 Reverse_String

public class Reverse_String {
    public String reverseString(String s) {

//        StringBuilder strBuilder = new StringBuilder(s);
//
//        int i = 0;
//        int j = s.length() - 1;
//
//        while (i < j) {
//            strBuilder.setCharAt(i, s.charAt(j));
//            strBuilder.setCharAt(j, s.charAt(i));
//            i++;
//            j--;
//        }
//        return strBuilder.toString();

        StringBuilder str = new StringBuilder(s.length());
        int i = 0, j = s.length() -1;
        while(i<=j){
            str.setCharAt(j, s.charAt(i));
            str.setCharAt(i, s.charAt(j));
            i++;
            j--;

        }
        return str.toString();
    }

    public static void main(String[] args){
        String str = "hello";
        Reverse_String reverse_string = new Reverse_String();
        System.out.println(reverse_string.reverseString(str));
    }
}
