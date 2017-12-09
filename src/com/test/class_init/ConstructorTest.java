package com.test.class_init;

public class ConstructorTest {
    public static void main(String[] args) {
        new Meal();
    }
}
class Meal {
    public Meal() {
        System.out.println("meal");
    }
    Bread bread = new Bread();
}
class Bread {
    public Bread() {
        System.out.println("bread");
    }
}