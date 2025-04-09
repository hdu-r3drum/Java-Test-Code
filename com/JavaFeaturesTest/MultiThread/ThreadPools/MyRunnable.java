package com.javaFeaturesTest.MultiThread.ThreadPools;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " is running! " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
