package com.JavaFeaturesTest;

import java.util.ArrayList;
import java.util.Collections;

public class JavaMethodRef {

    public static void main(String[] args) {
        com.JavaFeaturesTest.JavaMethodRef javaMethodRef = new com.JavaFeaturesTest.JavaMethodRef();
        javaMethodRef.Test(new com.Interfaces.MyInterface() {
            @Override
            public void doSomething() {
                System.out.println("Doing something");
            }
        });
        javaMethodRef.Test(new MyClass()::doSomething);
        javaMethodRef.Test(JavaMethodRef::RefMethod);

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4 ,5, 6, 7, 8, 9, 10);

        Integer[] arr2 = list.stream()
            .filter(i -> i % 2 == 0)
            .toArray(Integer[]::new);
        for (Integer i : arr2) {
            System.out.println(i);
        }
    }

    private void Test(com.Interfaces.MyInterface myInterface) {
        myInterface.doSomething();
    }

    private static void RefMethod() {
        System.out.println("RefMethod doing something");
    }

    static class MyClass implements com.Interfaces.MyInterface {
        @Override
        public void doSomething() {
            System.out.println("Doing something");
        }
    }
}
