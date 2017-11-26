package com.leetcode.number;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = countSquare(n);
        while (true) {
            if (result == 1)
                return true;

            if (set.contains(result))   // 重复出现时则无限循环
                return false;
            else
                set.add(result);

            result = countSquare(result);
        }
    }

    public int countSquare(int n) {
        int result = 0;
        while (n != 0) {
            int temp = n % 10;
            n /= 10;
            result += temp*temp;
        }
        return result;
    }


//    public boolean isHappy(int n) {
//        String s = String.valueOf(n);
//        Set<Integer> set = new HashSet<>();
//        int result = countSquare(s);
//        while (true){
//            if (result == 1)
//                return true;
//
//            if (set.contains(result))
//                return false;
//            else
//                set.add(result);
//
//            s = String.valueOf(result);
//            result = countSquare(s);
//        }
//    }
//
//    public int countSquare(String s) {
//        int result = 0;
//        for (int i = 0; i < s.length(); i++){
//            result += Math.pow((int)s.charAt(i)-48, 2);
//        }
//        return result;
//    }


    public static void main(String[] args) {
        int n = 19;
        System.out.print((new Happy_Number()).isHappy(n));
    }
}
