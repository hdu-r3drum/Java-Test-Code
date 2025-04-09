package com.algorithm;
import java.util.Scanner;

public class StringToInteger{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            System.out.println(myAtoi(s));
        }
    }
    public static int myAtoi(String s) {
        int result = 0;
        boolean end = false;
        boolean flag = true;
        boolean sign = true;
        boolean digital = false;
        boolean zero = true;
        int count = 0;
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
                if(s.charAt(i) == '0' && zero){
                    i++;
                    continue;
                }else{
                    zero = false;
                }
                count++;
                if(count >= 10||(result / 10 > Integer.MAX_VALUE / 10) && flag || flag && (result / 10 == Integer.MAX_VALUE / 10) && (s.charAt(i) - '0') >= 7){
                    return Integer.MAX_VALUE;
                }else if(count >= 10 || (result > Integer.MAX_VALUE / 10) && !flag || !flag && (result / 10 == Integer.MAX_VALUE / 10) && (s.charAt(i) - '0') >= 8){
                    return Integer.MIN_VALUE;
                }
                result = result + (s.charAt(i) - '0');
                if(!end){
                    result = result * 10;
                }
                sign = false;
                digital = true;
            }else{
                digital = false;
                end = true;
            }
            i++;
        }
        if(!digital){
            result = result / 10;
        }
        return (flag)? result: -result;
    }
}