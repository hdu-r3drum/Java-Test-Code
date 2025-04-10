package com.javaFeaturesTest.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetClassMethodsAndInvoke {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.javaFeaturesTest.Reflect.MyClass");

        // 父类方法获取不到
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("----------------------");

        // 可获得父类方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("----------------------");

        // 调用方法
        MyClass mc = new MyClass();
        Method specificMethod = clazz.getDeclaredMethod("foo");
        specificMethod.setAccessible(true);
        specificMethod.invoke(mc);
    }
}