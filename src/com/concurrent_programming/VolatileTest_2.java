package com.concurrent_programming;

public class VolatileTest_2 {
    private volatile int a = 0;
    private int b = 0;

    public static void main(String[] args) {
        VolatileTest_2 test = new VolatileTest_2();
        test.a++;
        System.out.println(test.a);
        test.b = test.b + 2;
        test.a += test.b;
        System.out.println(test.b);
    }

}
