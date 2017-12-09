package com.test.aaa;

public class OverrideAndOverload {
    public static void main(String[] args){
        Child child = new Child();
        child.print_1("aaa");   // child 调用父类中的 print_1
        child.print_1(1.211);   // child 调用父类中 重载的 print_1
        child.print_2(0);   // child 调用父类中的 print_2
        child.print_1("aaa", 1);    // child 调用子类 重载的 print_1
        child.print_2(3);   // child 调用子类 覆盖（重写） print_2
    }
}

class Father {
    void print_1(String str) {
        System.out.println(str);
    }

    void print_1(double i) { // 重载了 print_1
        System.out.println(i);
    }

    void print_2(int i) {
        System.out.println(i);
    }
}

class Child extends Father {

    void print_1(String str, int i) { // 重载了 print_1
        System.out.println(str + i);
    }

    @Override
    void print_2(int i) { // 覆盖了 print_2
        super.print_2(i);
        System.out.println(i * 2);
    }
}