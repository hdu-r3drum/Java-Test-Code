package com.JavaFeaturesTest.Socket.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();
        os.write("Hello This is a TCP test! 加一点中文，需要用转换流".getBytes());

        socket.shutdownOutput();
        
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }

        os.close();
        socket.close();
    }
}
