package com.javaFeaturesTest.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewInstance {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class<?> clazz = MyClass.class;

        // 暴力反射
        Constructor<?> PrivateConstructor = clazz.getDeclaredConstructor(String.class);
        PrivateConstructor.setAccessible(true);

        MyClass mc = (MyClass) PrivateConstructor.newInstance("hello");
        
        
        System.out.println(mc.toString());


    }
}
