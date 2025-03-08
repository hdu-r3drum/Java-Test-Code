import java.util.Scanner;

public class RomanToInteger{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            System.out.println(romanToInt(s));
        }
    }
    public static int romanToInt(String s) {
        int[] value = {1000, 500, 100, 50, 10, 5, 1};
        char[] symbol = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int index = 0;
        int result = 0;
        for(int i = 0; i < s.length();){
            if(s.charAt(i) != symbol[index]){
                index++;
            }else{
                result = result + value[index];
                i++;
            }
        }
        return result;
    }
}