package com.simpleProject.RedEnvelop;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.catalog.CatalogResolver;

public class Main {
    static Object lock = new Object(); 
    
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Float> money = new ArrayList<>();
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        float totalMoney = 100f;
        int nums = 3;
        for(int i = 1; i <= nums - 1; i++){
            float temp = (float)Math.random() * totalMoney;
            temp = Float.parseFloat(nf.format(temp));
            money.add(temp);
            totalMoney = totalMoney - temp;
        }
        money.add(Float.valueOf(nf.format(totalMoney)));

        Person p1 = new Person(money);
        Person p2 = new Person(money);
        Person p3 = new Person(money);
        Person p4 = new Person(money);
        Person p5 = new Person(money);

        p3.setPriority(10);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        
    }
}
