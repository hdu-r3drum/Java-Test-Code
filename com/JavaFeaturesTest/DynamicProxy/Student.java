package com.javaFeaturesTest.DynamicProxy;

import com.javaFeaturesTest.DynamicProxy.Person;

public class Student implements Person{
    public String name;
    public int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public void sleep(){
        System.out.println(getClass() + " is sleeping!");
    }

    @Override
    public void eat(){
        System.out.println(getClass() + " is eating");
    }
}
