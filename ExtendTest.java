
public class ExtendTest {
    public static void main(String[] args) {
        Animal animal = new dog();
        animal.show();
    }
    public static class Animal{
        public void show(){
            System.out.println("I am Animal");
        }
        
    }

    public static class dog extends Animal{
        @Override
        public void show(){
            System.out.println("I am dog");
        }

    }
}
