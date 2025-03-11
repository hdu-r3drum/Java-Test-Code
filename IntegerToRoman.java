
import java.util.Scanner;

public class IntegerToRoman {
    public static void main(String[] args) {
        int nums;
        try (Scanner sc = new Scanner(System.in)) {
            nums = sc.nextInt();
        }
        System.out.println(intToRoman(nums));
    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num / 1000 != 0){
            for(int i = num / 1000; i >= 1;i--){
                sb.append("M");
            }
            num = num % 1000;
        }
        if(num / 100 != 0){
            if(num / 100 == 9){
                sb.append("CM");
            }
            else if(num / 100 >= 5){
                sb.append('D');
                for(int i = (num / 100) % 5;i>=1;i--){
                    sb.append('C');
                }
            }else{
                for(int i = 5 - (num / 100); i >= 1; i--){
                    sb.append('C');
                }
                sb.append('D');
            }
            num = num % 100;
        }
        if(num / 10 != 0){
            if(num / 10 == 9){
                sb.append("XC");
            }
            else if(num / 10 >= 5){
                sb.append('L');
                for(int i = (num / 10)%5;i>=1;i--){
                    sb.append('X');
                }
            }else{
                for(int i = 5 - (num / 10); i >= 1; i--){
                    sb.append('X');
                }
                sb.append('L');
            }
            num = num % 10;
        }
        if(num != 0){
            if(num == 9){
                sb.append("IX");
            }
            else if(num >= 5){
                sb.append('V');
                for(int i = num % 5;i>=1;i--){
                    sb.append('I');
                }
            }else{
                for(int i = 5 - num; i >= 1; i--){
                    sb.append('I');
                }
                sb.append('V');
            }
        }
        return sb.toString();
    }
}
