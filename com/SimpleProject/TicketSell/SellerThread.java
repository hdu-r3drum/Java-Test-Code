package com.simpleProject.TicketSell;

public class SellerThread extends Thread {

    @Override
    public void run() {
        while (Main.ticket != 0) {
            synchronized (Main.lock) {
                sell();
                System.out.println(Thread.currentThread().getName() + " is selling ticket, there is " + Main.ticket + " left!");
                Main.lock.notifyAll();
                try {
                    Thread.sleep((int) (Math.random() * 200));
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    private void sell() {
        Main.ticket--;
    }
}
