package com.javaFeaturesTest.Socket.FileTransferMutiThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        // while (true) { 
        //     Socket socket = ss.accept();
        //     Thread thread = new Thread(new MyRunnable(socket));
        //     thread.start();
        // }
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3,
             10,
              60,
               TimeUnit.SECONDS, 
               new ArrayBlockingQueue<>(2), 
               Executors.defaultThreadFactory(), 
               new ThreadPoolExecutor.AbortPolicy()
               );

        while (true) {
            Socket socket = ss.accept();
            pool.submit(new MyRunnable(socket));
        }
    }
}
