package com.javaFeaturesTest.MultiThread;

public class ThreadJoinMethod {
    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        myThread.start();

        myThread.join();

        for(int i = 0; i < 30; i++){
            System.out.println(i);
        }
    }
    private static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0 ; i<20;i++){
                System.out.println("Thread is running " + i);
            }
        }
    }
}
