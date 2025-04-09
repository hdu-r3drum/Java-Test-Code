package com.javaFeaturesTest;

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        // Iterator it = list.iterator();
        ListIterator<String> it = list.listIterator();

        while(it.hasNext()){
            // list.add("test");
            String s = it.next();
            if("lisi".equals(s)){
                it.remove();
                it.add("lisisi");
            }
            System.out.println(s);
        }
        for(String s : list){
            System.out.println(s);
        }
    }
}

