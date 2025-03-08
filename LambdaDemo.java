
import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {
    public static void main(String[] args) {
        String[] arr = {"apple", "orange", "banana", "pear", "plum"};
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        }); // Normal way
        MyPrintArray.MyPrintArray(arr);
        System.out.println();
        Arrays.sort(arr, (s1, s2)-> s2.length() - s1.length()); // Lambda way
        MyPrintArray.MyPrintArray(arr);
        System.out.println();
        Arrays.sort(arr, (s1, s2)->{
            for (int i = 0; i < s1.length() && i < s2.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.charAt(i) - s2.charAt(i);
                }
            }
            return s1.length() - s2.length();
        });
        MyPrintArray.MyPrintArray(arr);
    }
}
