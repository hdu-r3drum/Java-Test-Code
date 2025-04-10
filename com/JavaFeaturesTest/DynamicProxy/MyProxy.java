package com.javaFeaturesTest.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {

    public static void main(String[] args) {
        Student stu = new Student("zhangsan", 24);
        Person proxy = ProxyUtil.createProxy(stu);;
        proxy.sleep();
        proxy.eat();
    }
}

class ProxyUtil {

    public static Person createProxy(Student stu) {
        @SuppressWarnings("Convert2Lambda")
        Person p = (Person) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Person.class},
                new InvocationHandler() {
            @Override
            public Object invoke(Object Proxy, Method method, Object[] args) throws Throwable {
                // 1 代理的对象
                // 2 要运行的方法
                // 3 调用方法时候传递的参数

                if ("sleep".equals(method.getName())) {
                    System.out.println("代理调用sleep方法");
                    System.out.println("Do something...");
                } else if ("eat".equals(method.getName())) {
                    System.out.println("代理调用eat方法");
                    System.out.println("Do something...");
                }
                return method.invoke(stu, args);
            }
        }
        );
        return p;
    }
}
