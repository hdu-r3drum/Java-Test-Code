package com.JavaFeaturesTest.MultiThread;

public class JavaThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        
        t1.start();
        t2.start();
        System.out.println("1111");
        t1.sleep(3000);
        System.out.println("2222");
        Thread t = Thread.currentThread();
        System.out.println("3333");
        Thread.sleep(3000);
        System.out.println("4444");
        System.out.println(t.getName());
    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread :" + getName() + " is running");
    }
}
