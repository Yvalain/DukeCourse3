package com.edu.yae.course2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipherTest {
    private String filePath;
    private int key;
    private int key2;

    @Before
    public void executedBeforeEach() {
        filePath = "/Users/yvalain/MyProjects/Java/JavaProgrammingCourse2/test/message3.txt";
        key = 23;
        key2 = 17;
    }

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
        CaesarCipher caesarCipher = new CaesarCipher();
        String message = getFileText(filePath);
        String encrypted = caesarCipher.encrypt(message, key);
        String decrypted = caesarCipher.encrypt(encrypted, 26 - key);
        Assert.assertTrue("The texts are differents ", decrypted.equals(message));

    }

    @Test
    public void testCaesar2Keys() {
        CaesarCipher caesarCipher = new CaesarCipher();
        String message = getFileText(filePath);
        System.out.println(message);
        String encrypted = caesarCipher.encryptTwoKeys(message, key, key2);
        System.out.println(encrypted);
        String decrypted = caesarCipher.encryptTwoKeys(encrypted, 26 - key, 26 - key2 );
        Assert.assertTrue("The texts are differents ", decrypted.equals(message));

    }
}
