package com.test.finalTest;

public class FinalClassTest {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        int i = 0;
        i = myClass.changeValue(i);
        System.out.println(i);
    }
}

class MyClass {
    int changeValue(final int i) {
        return i+1;
    }
}



