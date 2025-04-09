package com.javaFeaturesTest.MultiThread.ConsumerAndProducer;

public class ConsumerAndProducer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        Buffer buffer = new Buffer();

        consumer.setPriority(1);
        producer.setPriority(10);

        consumer.start();
        producer.start();
    }
}
