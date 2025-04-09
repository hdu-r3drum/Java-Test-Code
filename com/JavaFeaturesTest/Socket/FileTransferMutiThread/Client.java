package com.javaFeaturesTest.Socket.FileTransferMutiThread;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        File f = new File("com/JavaFeaturesTest/Socket/FileTransferMutiThread/pic.jpeg");
        FileInputStream fis = new FileInputStream(f);

        Socket socket = new Socket("127.0.0.1", 10000);
        OutputStream os = socket.getOutputStream();
        byte[] buffer = new byte[1024 * 1024 * 8];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        socket.shutdownOutput();

        socket.close();
        fis.close();
    }
}
