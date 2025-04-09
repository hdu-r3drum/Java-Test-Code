package com.simpleProject.TicketSell;

public class Main {

    static int ticket = 1000;
    static Object lock = new Object();

    public static void main(String[] args) {
        SellerThread t1 = new SellerThread();
        SellerThread t2 = new SellerThread();
        SellerThread t3 = new SellerThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
