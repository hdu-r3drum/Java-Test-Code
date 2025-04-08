package com.SimpleProject.RedEnvelop;

import java.util.ArrayList;

public class Person extends Thread{

    private ArrayList<Float> money;

    private boolean flag = true;

    @Override
    public void run(){
        while(!money.isEmpty() && flag){
            synchronized (Main.lock) {
                if(!money.isEmpty()){
                    System.out.println(Thread.currentThread().getName() + " get " + money.get(0) + " yuan");
                    money.remove(0);
                    
                }else{
                    System.out.println(Thread.currentThread().getName() + " missed");
                    
                }
                flag = false;
                Main.lock.notifyAll();
            }
        }
    }
    
    public Person(ArrayList<Float> money){
        this.money = money;
    }

}
