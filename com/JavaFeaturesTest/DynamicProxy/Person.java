package com.javaFeaturesTest.DynamicProxy;

public interface Person {
    // 所有想要被代理的方法写在接口中
    public abstract void sleep();

    public abstract void eat();
}
