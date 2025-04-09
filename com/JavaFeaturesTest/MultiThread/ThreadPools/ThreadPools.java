package com.javaFeaturesTest.MultiThread.ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService Pool1 = Executors.newCachedThreadPool(); // 无上限

        ExecutorService Pool2 = Executors.newFixedThreadPool(3); // 有上限
        

        // 提交任务
        Pool1.submit(new MyRunnable());
        Pool1.submit(new MyRunnable());
        Pool1.submit(new MyRunnable());
        Pool1.submit(new MyRunnable());
        Pool1.submit(new MyRunnable());

        Pool1.shutdown();
    }
}
