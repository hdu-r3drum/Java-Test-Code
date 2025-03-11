public class StringAppendTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a" + "b" + "c";
        StringBuilder sb = new StringBuilder();
        System.out.println(s1 == s2);
    }
}
