package com.edu.yae.course2;

import org.junit.Test;

import java.io.*;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipherTest {

    public String getFileText(String filePath) {
        String line;
        String text = "";

        try {
            FileReader fileReader = new FileReader(new File(filePath));
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                text = text.concat(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @Test
    public void testCaesar() {
        String filePath = "/Users/yvalain/MyProjects/Java/JavaProgrammingCourse2/test/message1.txt";
        CaesarCipher caesarCipher = new CaesarCipher();
        String message = getFileText(filePath);
        int key = 17;
        String encrypted = caesarCipher.encrypt(message, key);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = caesarCipher.encrypt(encrypted, 26 - key);
        System.out.println("Decrypted: " + decrypted);

    }
}
