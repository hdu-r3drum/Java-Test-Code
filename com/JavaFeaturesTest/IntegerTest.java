package com.javaFeaturesTest;
public class IntegerTest {
    public static void main(String[] args) {
        String s1 = Integer.toBinaryString(99);
        System.out.println(s1);

        String s2 = Integer.toOctalString(99);
        System.out.println(s2);

        Integer i = Integer.valueOf(99);
        System.out.println(i);
    }
}
