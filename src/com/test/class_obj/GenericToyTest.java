package com.test.class_obj;

public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // newInstance() 返回确切类型
        FancyToy fancyToy = ftClass.newInstance();
        System.out.println(ftClass.newInstance().getClass());
        System.out.println("----------------------------------");

        // 某个类，它是 FancyToy 的超类
        Class<? super FancyToy> up = ftClass.getSuperclass();

//        Class<Toy> up2 = ftClass.getSuperclass(); // This won't compile:

        // newInstance() 无法返回精确的类型
        Toy obj_1 = (Toy)up.newInstance();
//        Object obj = up.newInstance();
        System.out.println(obj_1.getClass());
    }
}
