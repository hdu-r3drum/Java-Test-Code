package com.JavaFeaturesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyTest {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\Linn\\Desktop\\Java-Test-Code\\com\\resources\\src");
        File dest = new File("C:\\Users\\Linn\\Desktop\\Java-Test-Code\\com\\resources\\dest");
        try {
            copyDir(src, dest);
        } catch (IOException e) {
            System.out.println("IO Exception!" + e.getMessage());
        }
    }

    // private static void copyDir(File src, File dest) throws IOException{
    //     dest.mkdirs();
    //     File[] files = src.listFiles();
    //     for (File file : files) {
    //         if(file.isFile()){
    //             FileInputStream fis = new FileInputStream(src);
    //             FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
    //             byte[] bytes = new byte[1024];
    //             int len;
    //             while((len = fis.read(bytes)) != -1){
    //                 fos.write(bytes, 0, len);
    //             }
    //             fos.close();
    //             fis.close();
    //         }else{
    //             copyDir(file, new File(dest, file.getName()));
    //         }
    //     }
    // }
    
    private static void copyDir(File src, File dest) throws IOException {
        // 1. 检查源目录是否存在
        if (!src.exists()) {
            throw new FileNotFoundException("源目录不存在: " + src.getAbsolutePath());
        }

        // 2. 创建目标目录
        if (!dest.exists() && !dest.mkdirs()) {
            throw new IOException("无法创建目标目录: " + dest.getAbsolutePath());
        }

        // 3. 遍历文件
        File[] files = src.listFiles();
        if (files == null) {
            throw new IOException("无法访问源目录内容: " + src.getAbsolutePath());
        }

        for (File file : files) {
            File destFile = new File(dest, file.getName());
            if (file.isDirectory()) {
                // 递归复制子目录
                copyDir(file, destFile);
            } else {
                // 使用 try-with-resources 自动关闭流
                try (InputStream fis = new FileInputStream(file);
                     OutputStream fos = new FileOutputStream(destFile)) {
                    byte[] buffer = new byte[1024 * 1024]; // 1MB 缓冲区
                    int len;
                    while ((len = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    System.err.println("复制文件失败: " + file.getAbsolutePath());
                    throw e;
                }
            }
        }
    }

}
