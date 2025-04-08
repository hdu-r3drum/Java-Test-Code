package com.JavaFeaturesTest.Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10086);

        Socket s = socket.accept();
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");

        int b;
        while((b = isr.read()) != -1){
            System.out.print((char)b);
        }
         
        s.close();
        socket.close();
    }
}
