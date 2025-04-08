package com.JavaFeaturesTest.MultiThread;

public class JavaThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            for(int i = 0; i < 100; i++) {
                System.out.println("Thread 1 is running " + i);
                Thread.yield();
            }
        }, "Thread 1");
        Thread thread2 = new Thread(()->{
            for(int i = 0; i < 100; i++) {
                System.out.println("Thread 2 is running " + i);
            }
        }, "Thread 2");

        thread1.setPriority(1);
        thread2.setPriority(10);

        // int count = 0;
        // for(int i = 0; i< 5; i++) {
        //     new Thread(()->{
        //         count++;
        //     }).start();
        // }
        // System.out.println(count);

        thread2.setDaemon(true);
        
        thread1.start();
        thread2.start();
        
    }
}
