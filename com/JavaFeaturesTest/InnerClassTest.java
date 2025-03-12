public class InnerClassTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        // InnerClassTest test = (InnerClassTest) p1.clone();
    }
}

class Person{
    private String name = null;

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}