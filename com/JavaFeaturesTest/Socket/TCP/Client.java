package com.JavaFeaturesTest.Socket.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();
        os.write("Hello This is a TCP test! 加一点中文，需要用转换流".getBytes());

        os.close();
        socket.close();
    }
}
