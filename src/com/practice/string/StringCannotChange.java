package com.practice.string;

public class StringCannotChange {
    public static void main(String[] args) {
        // s 是对 常量存储区 中 "s" 的引用
        String s = "s";

        // s2 是对 常量存储区 中 "s" 的引用
        String s2 = "s";

        // s3（存储于内存的栈区，指向了新对象的首地址） 是对 一个新对象（存储于内存的堆区）的 引用
        String s3 = new String("s");

        // s4 也是一个对新对象的引用，但和 s3 分别指向不同的对象
        String s4 = new String("s");

        System.out.println(s == s2);  // true
        System.out.println(s3 == s2); // false
        System.out.println(s3 == s4); // false
        System.out.println("------------------------------");
        /*
        * A String's hashCode() method is calculated based on the chars it contains.
        * If two String objects contain the same chars with the same case and in the same order,
        * then they will have the same hashCode().
        * */
        System.out.println(StringCannotChange.class.getName() + "@" + Integer.toHexString(s.hashCode()));
        System.out.println(StringCannotChange.class.getName() + "@" + Integer.toHexString(s2.hashCode()));
        System.out.println(StringCannotChange.class.getName() + "@" + Integer.toHexString(s3.hashCode()));
        System.out.println(StringCannotChange.class.getName() + "@" + Integer.toHexString(s4.hashCode()));
        System.out.println("------------------------------");

        System.out.println(s.equals(s2));   // true
        System.out.println(s.equals(s3));   // true
        System.out.println(s.equals(s4));   // true
        System.out.println("------------------------------");

        StringCannotChange stringCannotChange = new StringCannotChange();
        System.out.print(stringCannotChange);
        System.out.println("------------------------------");

        String str = "test string";
        System.out.println(str);
        System.out.println("------------------------------");

        String a = "hello2";
        final String b = "hello";
        String c = b + 2;
        System.out.println((a == c));

    }
}



