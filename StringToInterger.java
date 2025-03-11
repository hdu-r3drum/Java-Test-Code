import java.util.Scanner;

public class StringToInterger{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.next();
            System.out.println(myAtoi(input));
        }    
    }
    private static int myAtoi(String s){
        int result = 0;
        boolean end = false;
        boolean flag = true;
        boolean sign = true;
        boolean digital = false;
        int i = 0;
        while(i < s.length() && !end){
            if(s.charAt(i) == ' ' && !digital){
                i++;
                continue;
            }
            if(s.charAt(i) == '-' && sign){
                flag = false;
                i++;
                sign = false;
                continue;
            }else if(s.charAt(i) == '+' && sign){
                flag = true;
                i++;
                sign = false;
                continue;
            }
            if((s.charAt(i) == '+' || s.charAt(i) == '-') && sign == false){
                end = true;
            }
            if(i == s.length() - 1){
                end = true;
            }
            if('0' <= s.charAt(i) && s.charAt(i) <= '9'){
                
                if(result >= (Integer.MAX_VALUE / 10 - (s.charAt(i) - '0') - 1) && flag){
                    return Integer.MAX_VALUE;
                }else if(result >= (Integer.MAX_VALUE / 10 - (s.charAt(i) - '0')) && !flag){
                    return Integer.MIN_VALUE;
                }
                result = result + (s.charAt(i) - '0');
                result = result * 10;
                sign = false;
                digital = true;
            }else{
                end = true;
            }
            i++;
        }
        result = result / 10;
        return (flag)? result: -result;
    }
}