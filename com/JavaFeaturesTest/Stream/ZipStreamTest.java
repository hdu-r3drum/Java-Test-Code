package com.JavaFeaturesTest.Stream;

import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamTest {
    public static void main(String[] args) {
        
    }

    private static void zip(File src, File dest, ZipOutputStream zos){
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                ZipEntry entry = new ZipEntry(null);
                
            }            
        }
    }

    private static void unzip(File src, File dest){

    }
}
