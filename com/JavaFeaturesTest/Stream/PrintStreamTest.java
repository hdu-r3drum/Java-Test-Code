package com.javaFeaturesTest.Stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) throws Exception{
        // PrintStream ps = new PrintStream(System.out);
        // Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        // while(! s.equals("exit")){
        //     ps.println(s);
        //     s = sc.next();
        // }

        // File f = new File("com\\resources\\PrintStreamOut.txt");
        // PrintStream ps = 
        //     new PrintStream(f , "UTF-8");
        
        // Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        // while(! s.equals("exit")){
        //     ps.print(s);
        //     s = sc.next();
        // }
        // ps.close();

        File f = new File("com\\resources\\PrintStreamOut.txt");
        PrintStream ps = 
            new PrintStream(f , "UTF-8");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while((s = br.readLine()) != null){
            if(s.equals("exit")){
                break;
            }
            ps.print(s + System.getProperty("line.separator"));
        }
        ps.close();
    }
}
