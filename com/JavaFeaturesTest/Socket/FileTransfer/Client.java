package com.javaFeaturesTest.Socket.FileTransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.211.55.6", 10000);
        FileInputStream fis = new FileInputStream(new File("com/JavaFeaturesTest/Socket/FileTransfer/File.txt"));
        byte[] buffer = new byte[1024];
        OutputStream os = socket.getOutputStream();
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        socket.shutdownOutput();

        fis.close();
        socket.close();
    }
}
