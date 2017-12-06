package com.test.bit_operator;

public class ShiftOperator {
    public static void main(String[] args){
        int a = 128;    // 二进制表示： 符号位     9876543210
                        // 二进制表示：   0         10000000
        int b = 3;
        System.out.println("左移位 ‘<<’ 操作符： a << b = "+ (a << b));
        System.out.println("（有符号）右移位 ‘>>’ 操作符： a >> b = "+ (a >> b));
        System.out.println("（无符号）右移位 ‘>>>’ 操作符： a >>> b = "+ (a >>> b));

        int c = -128;    // 二进制表示： 符号位     9876543210
                         // 二进制表示：   1         10000000
        System.out.println("左移位 ‘<<’ 操作符： c << b = "+ (c << b));
        System.out.println("（有符号）右移位 ‘>>’ 操作符： c >> b = "+ (c >> b));
        System.out.println("（无符号）右移位 ‘>>>’ 操作符： c >>> b = "+ (c >>> b));

    }
}
