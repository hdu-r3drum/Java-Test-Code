package com.javaFeaturesTest;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.classes.Student;

public class HashMapPratice {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<>();
        
        Student s1 = new Student(23, "zhangsan");
        Student s2 = new Student(24, "lisi");
        Student s3 = new Student(25, "wangwu");
        Student s4 = new Student(25, "wangwu");

        hm.put(s1, "jiangsu");
        hm.put(s2, "zhejiang");
        hm.put(s3, "fujian");
        hm.put(s4, "shandong");

        Set<Student> keySet = hm.keySet();
        for(Student s : keySet){
            System.out.print(s.toString() + "=");
            System.out.println(hm.get(s));
        }

        Set<Entry<Student,String>> entries = hm.entrySet();
        for(Entry<Student, String> entry : entries){
            System.out.print(entry.getValue() + " ");
            System.out.println(entry.getKey().toString());
        }
    }
}
