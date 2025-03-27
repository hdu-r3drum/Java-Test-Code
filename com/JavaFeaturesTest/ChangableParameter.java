package com.JavaFeaturesTest;

public class ChangableParameter {
    public static void main(String[] args) {
        System.out.println(add(1, 2, 3, 4, 5));
        System.out.println(add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
    // 本质上是数组
    public static int add(int... num){
        int sum = 0;
        for(int i : num){
            sum += i;
        }
        return sum;
    }
}
