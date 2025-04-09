package com.javaFeaturesTest.Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10086);

        Socket s = socket.accept();
        InputStream is = s.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");

        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        String str = "收到数据 返回数据";
        OutputStream os = s.getOutputStream();
        os.write(str.getBytes());
        s.shutdownOutput();

        s.close();
        socket.close();
    }
}
