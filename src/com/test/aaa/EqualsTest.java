package com.test.aaa;

public class EqualsTest {
    public static void main(String[] args) {
        Value v_1 = new Value(100);
        Value v_2 = new Value(100);
        System.out.println(v_1 == v_2);
        System.out.println(v_1.equals(v_2));
    }
}

class Value {
    private int i;

    public Value(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Value value = (Value) o;

        return i == value.i;
    }

    @Override
    public int hashCode() {
        return i;
    }
}


//        Integer n1 = new Integer(47);
//        Integer n2 = new Integer(47);
//        System.out.println(n1 == n2);   // false
//        System.out.println(n1.equals(n2));  //true
//
//        Integer n3 = 47;
//        Integer n4 = 47;
//        System.out.println(n3 == n4);   //true
//        System.out.println(n3.equals(n4));  //true
//
//        System.out.println(n1 == n3);   //false
//        System.out.println(n1.equals(n3));  //true
//
//        // [-128,127] 直接指向缓存区中的数据，这个范围以外的需要 new 一个新的对象
//        Integer n5 = 128;
//        Integer n6 = 128;
//        System.out.println(n5 == n6);   //false
//        System.out.println(n5.equals(n6));  //true
