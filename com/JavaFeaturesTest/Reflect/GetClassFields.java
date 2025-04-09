package com.javaFeaturesTest.Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetClassFields {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<? extends Object> clazz = Class.forName("com.javaFeaturesTest.Reflect.MyClass");
        MyClass mc = (MyClass) clazz.getConstructor(String.class, int.class).newInstance("hello", 111);

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------------------");

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println("---------------------");

        // Throws exception
        Field specificField = clazz.getDeclaredField("flag");
        System.out.println(specificField);

        System.out.println("---------------------");

        // Throws exception
        Field normalField = clazz.getField("age");
        System.out.println(normalField);

        System.out.println("---------------------");

        System.out.println(normalField.get(mc));
    }
}
