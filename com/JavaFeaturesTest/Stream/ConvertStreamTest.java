package com.javaFeaturesTest.Stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class ConvertStreamTest {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("com\\resources\\src\\chinese.txt");
        int len;
        while((len = fis.read()) != -1){
            System.out.print((char) len);
        }
        fis.close();
        // 乱码
        InputStreamReader isr = new InputStreamReader(new FileInputStream("com\\resources\\src\\chinese.txt"), "UTF-8");
        int chr;
        while((chr = isr.read()) != -1){
            System.out.print((char) chr);
        }
        isr.close();

        // JDK 11
        FileReader fr = new FileReader("com\\resources\\src\\chinese.txt", Charset.forName("UTF-8"));
        int ch;
        while((ch = fr.read()) != -1){
            System.out.print((char) ch);
        }
        fr.close();

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("com\\resources\\src\\outputChinese.txt"), "UTF-8");
        osw.write("测试");
        osw.close();

        //JDK 11
        FileWriter fw = new FileWriter("com\\resources\\src\\outputChinese.txt", Charset.forName("UTF-8"), true);
        fw.write("+追加的中文字符串");
        fw.close();
    }
}
