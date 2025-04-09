package com.javaFeaturesTest.MultiThread.ConsumerAndProducer;

public class Consumer extends Thread {

    @Override
    public void run() {
        while (Buffer.MAX > 0) {
            synchronized(Buffer.lock){
                if(Buffer.count == 0){
                    try {
                        Buffer.lock.wait();
                    } catch (InterruptedException ex) {
                    }
                }else{
                    Buffer.lock.notifyAll();
                    Buffer.count--;
                    Buffer.MAX--;
                    System.out.println("Consumer is using, there is " + Buffer.count + " left");
                    try {
                        Thread.sleep((int)Math.random()*500);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }
    }
}
