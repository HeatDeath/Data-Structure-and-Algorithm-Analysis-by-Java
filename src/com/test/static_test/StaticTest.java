package com.test.static_test;

public class StaticTest extends Base {
    static {
        System.out.println("test static");
    }

    public StaticTest() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new StaticTest();
    }
}
class Base {

    static {
        System.out.println("base static");
    }

    public Base() {
        System.out.println("base constructor");
    }
}
