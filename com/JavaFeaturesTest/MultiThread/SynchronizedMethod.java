package com.JavaFeaturesTest.MultiThread;

public class SynchronizedMethod {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr, "t1");
        Thread t2 = new Thread(mr, "t2");
        Thread t3 = new Thread(mr, "t3");

        t1.start();
        t2.start();
        t3.start();


    }
    private static class MyRun implements Runnable{
        int count = 0;
        @Override
        public void run(){
            while(add());
        }
        private synchronized boolean add(){
            if(count == 1000){
                return false;
            }else{
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
                count++;
                System.out.println(Thread.currentThread().getName() + " count = " + count);
            }
            return true;
        }
    }
}