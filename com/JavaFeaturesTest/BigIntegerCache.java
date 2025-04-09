package com.javaFeaturesTest;

import java.math.BigInteger;

public class BigIntegerCache {
    public static void main(String[] args) {
        BigInteger bi1 = BigInteger.valueOf(16);
        BigInteger bi2 = BigInteger.valueOf(16); //-16 ~ +16
        System.out.println(bi1 == bi2);

        BigInteger bi3 = BigInteger.valueOf(17);
        BigInteger bi4 = BigInteger.valueOf(17);
        System.out.println(bi3 == bi4);

    }
}
