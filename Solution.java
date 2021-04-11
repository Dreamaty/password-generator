package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = null;
        try {
            password = getPassword();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        boolean haveNumber = false;
        boolean haveUpperCase = false;
        boolean haveLowerCase = false;

        byte[] password = new byte[8];

        for (int i = 0; i < 8; i++) {
            int flag = new Random().nextInt(3);
            switch (flag){
                case 0:
                    password[i] = (byte) (new Random().nextInt(10) + 48);
                    haveNumber = true;
                    break;
                case 1:
                    password[i] = (byte) (new Random().nextInt(26) + 65);
                    haveUpperCase = true;
                    break;
                case 2:
                    password[i] = (byte) (new Random().nextInt(26) + 97);
                    haveLowerCase = true;
                    break;
            }
        }
        if(haveLowerCase && haveNumber && haveUpperCase) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(password);
            return byteArrayOutputStream;
        }else return getPassword();
    }
}
