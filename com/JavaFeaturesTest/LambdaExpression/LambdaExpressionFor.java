package com.javaFeaturesTest.LambdaExpression;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class LambdaExpressionFor {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("wangwu");
        // 利用匿名内部类形式
        coll.forEach(new Consumer<String>(){
            @Override
            public void accept(String s){
                System.out.println(s);
            }
        });
        // 利用Lambda表达式形式
        coll.forEach((String s)->{
            System.out.println(s);
        });
    }
}
