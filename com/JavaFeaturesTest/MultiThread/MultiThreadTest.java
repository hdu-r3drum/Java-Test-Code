package com.JavaFeaturesTest.MultiThread;

import java.util.concurrent.Callable;

public class MultiThreadTest {
    public static void main(String[] args) throws Exception{
        // using thread class
        // MyThread1 t1 = new MyThread1();
        // t1.setName("Thread 1");
        // MyThread1 t2 = new MyThread1();
        // t2.setName("Thread 2");
        // t1.start();
        // t2.start();

        // using runnable interface
        MyRun myRun = new MyRun();
        Thread t3 = new Thread(myRun);

        // annonymous inner class
        // Thread t3 = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         for (int i = 0; i < 10; i++){
        //             System.out.println("Thread:" + Thread.currentThread().getName() + " is running");
        //         }
        //     }
        // });

        // lambda expression
        // Thread t3 = new Thread(()->{
        //     for (int i = 0; i < 10; i++){
        //         System.out.println("Thread:" + Thread.currentThread().getName() + " is running");
        //     }
        // });
        

        t3.setName("Thread 3");
        t3.start();
        
        // using Callable interface + FutureTask
        // FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        // Thread t4 = new Thread(futureTask);
        // t4.setName("Thread 4");
        // t4.start();
        // System.out.println("Thread 4 result: " + futureTask.get().toString());


    }
    private static class MyThread1 extends Thread{
        @Override
        public void run(){
            for (int i = 0; i < 100; i++) {
                System.out.println("Thread:" + this.getName() + " is running");
            }
        }
    }
    private static class MyRun implements Runnable{
    
        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                System.out.println("Thread is running");
            }
        }
    
    }

    private static class MyCallable implements Callable<Integer>{
        @Override
        public Integer call() throws Exception{
            int sum = 0;
            for(int i = 1; i <= 100; i++){
                sum += i;
            }
            return sum;
        }
    }


}
