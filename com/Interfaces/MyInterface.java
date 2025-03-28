package com.Interfaces;

@FunctionalInterface
public interface MyInterface {
    void doSomething();

    default void doSomethingElse() {
        System.out.println("Doing something else");
    }
}
