package com.JavaFeaturesTest.MultiThread;

import com.classes.Singleton;

public class SynchronizedCodeBlockTest {
    static final Singleton singleton = Singleton.getInstance();
    static int count = 0;
    public static void main(String[] args) throws Exception{
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count:" + count);
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            synchronized (singleton) {
                for (int i = 0; i < 100000; i++){
                    count++;
                    System.out.println(getName() + ": " + count);
                }
            }
        }
    }
    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            synchronized (singleton) {
                for (int i = 0; i < 100000; i++){
                    count--;
                    System.out.println(getName() + ": " + count);
                }
            }
        }
    }
}
