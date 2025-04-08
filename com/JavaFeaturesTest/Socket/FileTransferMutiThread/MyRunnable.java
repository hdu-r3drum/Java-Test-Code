package com.JavaFeaturesTest.Socket.FileTransferMutiThread;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {

    private Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        UUID uuid = UUID.randomUUID();
        String name = uuid.toString().replace("-", "");
        try {
            FileOutputStream fos = new FileOutputStream("com/JavaFeaturesTest/Socket/FileTransferMutiThread/" + name + ".jpeg");
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024 * 1024 * 8];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            is.close();
            fos.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

    }

}
