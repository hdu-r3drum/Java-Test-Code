package com.JavaFeaturesTest.Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {

    public static void main(String[] args) throws Exception {

        InetAddress addr = InetAddress.getByName("127.0.0.1");

        int port = 10086;
        
        DatagramSocket ds = new DatagramSocket();

        String s = "This is a test!";
        byte[] bytes = s.getBytes();
        DatagramPacket p = new DatagramPacket(bytes ,bytes.length, addr, port);
        
        

        ds.send(p);

        ds.close();
    }
}
