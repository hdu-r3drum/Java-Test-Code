package com.javaFeaturesTest.Reflect;

public class MyClass {

    
    public String name;
    public int age;

    private boolean flag;

    private void foo(){
        System.out.println("foo is invoked!");
    }
 
    public MyClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    MyClass(){ 

    }
 
    protected MyClass(int age){
        this.age = age;
    }

    private MyClass(String name){
        this.name = name;
    }

    public void getName(){
        System.out.println(name);
    }

    public void getAge(){
        System.out.println(age);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyClass{");
        sb.append("name=").append(name);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
