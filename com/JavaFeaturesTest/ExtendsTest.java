package com.javaFeaturesTest;
public class ExtendsTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.eat();
        Student stu = (Student)p;
        stu.study();
    }
}
class Person{
    private void test(){
        System.out.println("I'm test.");
    }
    public void eat(){
        System.out.println("I'm eating.");
    }
}

class Student extends Person{
    public void study(){
        System.out.println("I'm studying.");
    }
}