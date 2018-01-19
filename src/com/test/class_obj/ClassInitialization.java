package com.test.class_obj;

import java.util.*;

class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 =
            ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println("---------------------------");
        // staticFinal 是编译期常量，不需要对 Initable 类进行初始化就可以被读取
        System.out.println(Initable.staticFinal);
        System.out.println("---------------------------");
        // staticFinal2 是非编译期常量，访问它将会强制进行类的初始化
        System.out.println(Initable.staticFinal2);
        System.out.println("---------------------------");
        // staticNonFinal 只是 static 域，在被读取之前，要先进行链接和初始化
        System.out.println(Initable2.staticNonFinal);
        System.out.println("---------------------------");
        // Class.forName 会对类进行初始化
        Class.forName("com.test.class_obj.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
        System.out.println("---------------------------");
    }
}