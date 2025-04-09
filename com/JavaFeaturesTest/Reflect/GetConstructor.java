package com.javaFeaturesTest.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import com.javaFeaturesTest.MultiThread.ConsumerAndProducer.Consumer;

public class GetConstructor {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> clazz = MyClass.class;
        Constructor<?>[] constructors1 = clazz.getConstructors();
        for(Constructor constructor : constructors1){
            System.out.println(constructor);
        }

        System.out.println("-----------------------------");

        Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors2){
            System.out.println(constructor);
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter);
            }
            System.out.println("Modifier : " + constructor.getModifiers());
        }

        System.out.println("-----------------------------");


        // Throws Exception
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

    }
}
class a extends MyClass{

}
