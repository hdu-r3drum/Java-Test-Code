package com.javaFeaturesTest.Socket.FileTransfer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BigTxtGen {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789 ";
        char[] chars = CHARACTERS.toCharArray();
        Random random = new Random();

        int sizeInBytes = 1024 * 1024 * 128;
        final int BUFFER_SIZE = 1024 * 1024;
        char[] buffer = new char[BUFFER_SIZE];

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("File.txt"))) {
            long remaining = sizeInBytes;
            while (remaining > 0) {
                int currentSize = (int) Math.min(remaining, BUFFER_SIZE);
                // 填充随机字符
                for (int i = 0; i < currentSize; i++) {
                    buffer[i] = chars[random.nextInt(chars.length)];
                }
                bw.write(buffer, 0, currentSize);
                remaining -= currentSize;
            }
        }
    }
}
