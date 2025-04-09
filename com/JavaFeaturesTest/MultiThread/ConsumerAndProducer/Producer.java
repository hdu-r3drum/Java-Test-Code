package com.javaFeaturesTest.MultiThread.ConsumerAndProducer;

public class Producer extends Thread {

    @Override
    public void run() {
        while (Buffer.MAX > 0) {
            synchronized (Buffer.lock) {
                if(Buffer.count == 0){
                    Buffer.count++;
                    System.out.println("Producer is producing, there is " + Buffer.count + " left");
                    Buffer.lock.notifyAll();
                    try {
                        Thread.sleep((int)Math.random()*500);
                    } catch (InterruptedException ex) {
                    }
                }else{
                    try {
                        Buffer.lock.wait();
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }
}
