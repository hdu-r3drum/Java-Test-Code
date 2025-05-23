package com.javaFeaturesTest.Socket.BrowserAccess;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        while (true) { 
            Socket socket = ss.accept();
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            int ch;
            while((ch = isr.read()) != -1){
                System.out.print((char) ch);
            }
        }
    }
}
