package com.JavaFeaturesTest;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class CommonIOTest {
    public static void main(String[] args) {
        File src = new File("com\\resources\\copyTest.txt");
        File dest = new File("com\\resources\\copyTestCopy.txt");
        try {
            FileUtils.copyFile(src, dest);
            System.out.println("File copied successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
