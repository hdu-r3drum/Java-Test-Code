package com.javaFeaturesTest;
public class EqualsTest {
    public static void main(String[] args) {
        String s = new String("abc");
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(s.equals(sb));
        System.out.println(sb.equals(s));

    }
}
