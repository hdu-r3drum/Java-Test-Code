package com.JavaFeaturesTest.Socket.FileTransfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);
        Socket socket = ss.accept();

        FileOutputStream fos = new FileOutputStream("File.txt");
        InputStream is = socket.getInputStream();
        int ch;
        while((ch = is.read()) != -1){
            fos.write(ch);
        }

        fos.close();
        ss.close();
    }
}
