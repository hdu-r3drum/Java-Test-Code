package com.JavaFeaturesTest;

public class InnerClassTest {
    // public static void main(String[] args) {
    //     Person p1 = new Person();
    //     // InnerClassTest test = (InnerClassTest) p1.clone();
    //     // Test2 t = new Test2(); // Cannot new
        
    // }

    private class Test1{
        public void hello1(){

        }
        public class Test2{
            public void hello2(){

            }
        }
    }

    public class Test3{
        public void hello3(){

        }
        private class Test4{
            public void hello4(){
                
            }
        }
    }
}

class Person{

    Person(int par, String zhangsan) {
    }
    private String name = null;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

