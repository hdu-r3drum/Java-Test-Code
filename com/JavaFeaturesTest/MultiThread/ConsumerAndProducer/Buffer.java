package com.javaFeaturesTest.MultiThread.ConsumerAndProducer;

public class Buffer {

    public static final Object lock = new Object();

    public static int count = 0;

    public static int MAX = 100;

    public static void add() {
        count++;
    }

    public static int pick() {
        return 0;
    }
}
