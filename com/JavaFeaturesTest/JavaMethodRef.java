package com.JavaFeaturesTest;

import com.Interfaces.MyInterface;

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
