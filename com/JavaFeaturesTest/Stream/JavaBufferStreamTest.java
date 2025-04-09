package com.javaFeaturesTest.Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaBufferStreamTest {
    public static void main(String[] args) throws IOException{
        BufferedInputStream bis1 = 
            new BufferedInputStream(new FileInputStream("com\\resources\\src\\aaa.txt"));
        BufferedOutputStream bos1 =
            new BufferedOutputStream(new FileOutputStream("com\\resources\\src\\bbb.txt"));
        
        int len;
        while((len = bis1.read()) != -1){
            bos1.write(len);
        }
        bos1.close();
        bis1.close();

        BufferedInputStream bis2 = 
            new BufferedInputStream(new FileInputStream("com\\resources\\src\\aaa.txt"));
        BufferedOutputStream bos2 =
            new BufferedOutputStream(new FileOutputStream("com\\resources\\src\\ccc.txt"));
        
        byte[] bytes = new byte[1024];
        len = 1;
        while((len = bis2.read(bytes)) != -1){
            bos2.write(bytes, 0, len);
        }
        bos2.close();
        bis2.close();



    }
}
