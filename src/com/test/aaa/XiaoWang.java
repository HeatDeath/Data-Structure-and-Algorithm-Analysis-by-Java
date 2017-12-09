package com.test.aaa;

public class XiaoWang extends Student{
    public XiaoWang(int i) {
        super(i);
        System.out.println("I'm a XiaoWang");
    }
    public static void main(String[] args){
        new XiaoWang(1);
    }
}
class Student extends Person{
    public Student(int i) {
        super(i);
        System.out.println("I'm a student");
    }
}
class Person{
    public Person(int i) {
        System.out.println("I'm a person");
    }
}