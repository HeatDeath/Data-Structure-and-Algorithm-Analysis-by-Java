package com.test.class_obj;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        System.out.println(intClass.getSimpleName());
        intClass = double.class;
        System.out.println(intClass.getSimpleName());
        System.out.println("----------------------");

        Class<Integer> genericIntClass = int.class;
        System.out.println(genericIntClass.getSimpleName());

        genericIntClass = Integer.class; // Same thing
        System.out.println(genericIntClass.getSimpleName());

        System.out.println(int.class.equals(Integer.class));
        System.out.println("----------------------");

//        genericIntClass = double.class; // Illegal
//        Class<Number> genericNumberClass = int.class; // Illegal

        Class<? extends Number> classExtendNumber = int.class;
        System.out.println(classExtendNumber.getSimpleName());

    }
}
