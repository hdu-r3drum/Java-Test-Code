package com.javaFeaturesTest.Socket.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.stream.Stream;

public class Receive {
    public static void main(String[] args) throws Exception{
        DatagramSocket ds = new DatagramSocket(10086);
        byte[] bytes = new byte[1024];
        DatagramPacket p = new DatagramPacket(bytes, bytes.length);
        ds.receive(p);

        System.out.println(new String(p.getData()));
        System.out.println(p.getAddress());
        System.out.println(p.getPort());
    }
}
