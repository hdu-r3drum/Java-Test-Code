package com.javaFeaturesTest.Reflect;

public class GetClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1
        Class<?> clazz1 = Class.forName("com.javaFeaturesTest.Reflect.MyClass");
        System.out.println(clazz1);
        // System.out.println(clazz1.hashCode());


        // 2
        Class<?> clazz2 = MyClass.class;
        System.out.println(clazz2);
        // System.out.println(clazz2.hashCode());

        // 3
        MyClass mc = new MyClass("test", 12);
        Class<?> clazz3 = mc.getClass();;
        System.out.println(clazz3);
        // System.out.println(clazz3.hashCode());

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }
}
