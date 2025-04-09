package com.javaFeaturesTest.Stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileOutPutStreamTest{
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("com\\JavaFeaturesTest\\FieldTest.java");
        int b;
        while((b = fis.read()) != -1){
            System.out.print((char) b);
        }
        fis.close();
    }
}
