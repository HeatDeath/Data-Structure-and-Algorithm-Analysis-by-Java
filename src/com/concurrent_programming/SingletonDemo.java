package com.concurrent_programming;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}
class Singleton{
    private volatile static Singleton instance = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(instance==null) {
            synchronized (Singleton.class) {
                if(instance==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
