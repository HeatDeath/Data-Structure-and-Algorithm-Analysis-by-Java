package com.concurrent_programming;

import java.io.IOException;

public class ThreadInterruptMethod_2 {
    public static void main(String[] args) throws IOException {
        ThreadInterruptMethod_2 test = new ThreadInterruptMethod_2();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }

    class MyThread extends Thread{
        @Override
        public void run() {
            int i = 0;
            while(!isInterrupted() && i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }
    }
}
