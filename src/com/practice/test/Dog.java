package com.practice.test;

//这是这个程序的第一种编程方法，在main方法中先创建一个Dog类实例，然后在Dog类的构造方法中利用this关键字调用不同的bark方法。

//不同的重载方法bark是根据其参数类型的不同而区分的。

//注意：除构造器以外，编译器禁止在其他任何地方中调用构造器。


public class Dog {
    Dog() {
        this.bark();
    }

    void bark()//bark()方法是重载方法
    {
        System.out.println("no barking!");
        this.bark("female", 3.4);
    }

    void bark(String m, double l)//注意：重载的方法的返回值都是一样的，
    {
        System.out.println("a barking dog!");
        this.bark(5, "China");
    }

    void bark(int a, String n)//不能以返回值区分重载方法，而只能以“参数类型”和“类名”来区分
    {
        System.out.println("a howling dog");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
//        dog.bark();
//        dog.bark("male", 3.4);
//        dog.bark(5, "China");

    }
}

