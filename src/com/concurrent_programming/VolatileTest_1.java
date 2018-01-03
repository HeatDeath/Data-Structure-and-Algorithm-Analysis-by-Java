package com.concurrent_programming;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileTest_1 {
    public AtomicInteger inc = new AtomicInteger();

    public void increase() {
            inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final VolatileTest_1 test = new VolatileTest_1();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            }.start();
        }
        System.out.println(Thread.activeCount());

        while (Thread.activeCount() > 2)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}
