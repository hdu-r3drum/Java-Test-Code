package com.javaFeaturesTest.MultiThread;

public class RaceCondition {
    static int count = 0;

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100000; i++){
                count++;
                System.out.println("t1: " + count);
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100000; i++){
                System.out.println("t2: " + count);
                count--;
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count:" + count);

    }
}
