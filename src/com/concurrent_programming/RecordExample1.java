package com.concurrent_programming;

public class RecordExample1 {
    public static void main(String[] args){
        int a = 1;
        int b = 2;

        try {
            a = 3;           //A
            b = 1 / 0;       //B
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("a = " + a);
        }
    }
}
