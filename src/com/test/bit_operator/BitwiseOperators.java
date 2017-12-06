package com.test.bit_operator;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int c = 1;
        System.out.println("int a = 1;\n" + "int b = 0;\n" + "int c = 1;");
        System.out.println("-------------------------------------");


        System.out.println("按位 ‘与’(&) 操作符： a & b = "+ (a & b));
        System.out.println("按位 ‘与’(&) 操作符： a & c = "+ (a & c));
        System.out.println("-------------------------------------");

        System.out.println("按位 ‘或’(|) 操作符： a | b = "+ (a | b));
        System.out.println("按位 ‘或’(|) 操作符： b | b = "+ (b | b));
        System.out.println("-------------------------------------");

        // 如果输入为的某位是 1 ，但不全是 1，将会生成 1
        System.out.println("按位 ‘异或’(^) 操作符： a ^ b = "+ (a ^ b));
        System.out.println("按位 ‘异或’(^) 操作符： a ^ c = "+ (a ^ c));
        System.out.println("-------------------------------------");

        // 符号位也会取反
        System.out.println("按位 ‘非’(~) 操作符： ~(0) = "+ (~(0)));
        System.out.println("按位 ‘非’(~) 操作符： ~(1) = "+ (~(1)));
        System.out.println("按位 ‘非’(~) 操作符： ~(-1) = "+ (~(-1)));
        System.out.println("按位 ‘非’(~) 操作符： ~(-2) = "+ (~(-2)));
        System.out.println("-------------------------------------");

    }
}
