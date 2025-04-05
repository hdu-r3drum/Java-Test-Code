package com.dataStructure.HashMap;

import java.time.Duration;
import java.time.Instant;

public class MyHashMapTest {
    public static void main(String[] args) {
        Instant start = Instant.now();
        int times = 1000000;
        MyHashMap<Integer, Integer> hm = new MyHashMap<>();
        for (int i = 0; i < times; i++) {
            hm.put(i, i);
        }
        Instant end = Instant.now();
        System.out.println("MyHashMap put time: " + Duration.between(start, end).toMillis() + "ms");
        // System.out.println(hm.toString());
        // System.out.println(hm.size());
    }
}
