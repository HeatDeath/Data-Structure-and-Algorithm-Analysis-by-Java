package com.test.aaa;

public class School {
//    private Student student;
    private Teacher teacher;
    public School() {
        System.out.println("This is a school");
//        this.student = new Student();
        this.teacher = new Teacher();
    }
    public static void main(String[] args){
        new School();
    }
}

//class Student{
//    public Student(){
//        System.out.println("I'm a student");
//    }
//}

class Teacher{
    public Teacher(){
        System.out.println("I'm a teacher");
    }
}
