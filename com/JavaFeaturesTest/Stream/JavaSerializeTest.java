package com.javaFeaturesTest.Stream;

import com.classes.Student;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class JavaSerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Student stu1 = new SerializableStudent(23, "zhangsan");
        Student stu2 = new SerializableStudent(26, "lisi");
        Student stu3 = new SerializableStudent(30, "wangwu");

        ArrayList<Student> list = new ArrayList<>();

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        System.out.println(System.identityHashCode(stu1));

        // System.out.println(getObjectToString(stu) + "test");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("com\\resources\\Student.txt"));
        
        // oos.writeObject(stu1);
        // oos.writeObject(stu2);
        // oos.writeObject(stu3);
        oos.writeObject(list);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("com\\resources\\Student.txt"));

        Object o = ois.readObject();
        
        ois.close();
        
        ArrayList<Student> res = (ArrayList<Student>) o;
        for (Student s : res) {
            System.out.println(s.toString());            
        }
        

        // System.out.println(o);

        // System.out.println((SerializableStudent)o);

        // System.out.println(o instanceof Serializable);

        // System.out.println(System.identityHashCode(o));
    }
    // private static String getObjectToString(Object o){
    //     try {
    //         Method m = Object.class.getMethod("toString");
    //         return (String) m.invoke(o);
    //     } catch (Exception e) {
    //         return e.getMessage();
    //     }
    // }

}
class SerializableStudent extends com.classes.Student{

    private transient int test;

    public SerializableStudent() {
        this.test = 0;
        super(0, null);
    }
    
    public SerializableStudent(int age, String name){
        this.test = 0;
        super(age, name);
    }

}
