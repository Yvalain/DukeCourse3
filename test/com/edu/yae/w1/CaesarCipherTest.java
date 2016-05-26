package com.edu.yae.w1;

import com.edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipherTest {
    private int key;
    private int key2;
    FileResource fileRes;

    @Before
    public void executedBeforeEach() {
        fileRes = new FileResource("./test/message3.txt");
        key = 23;
        key2 = 17;
    }

    @Test
	public void testCaesar() {
		CaesarCipher caesarCipher = new CaesarCipher();
		
		String message = fileRes.asString();
		String encrypted = caesarCipher.encrypt(message, key);
		String decrypted = caesarCipher.encrypt(encrypted, 26 - key);
		Assert.assertTrue("The texts are differents ", decrypted.equals(message));
	}

    @Test
    public void testCaesar2Keys() {
        CaesarCipher caesarCipher = new CaesarCipher();
        String message = fileRes.asString();
        System.out.println(message);
        String encrypted = caesarCipher.encryptTwoKeys(message, key, key2);
        System.out.println(encrypted);
        String decrypted = caesarCipher.encryptTwoKeys(encrypted, 26 - key, 26 - key2 );
        Assert.assertTrue("The texts are differents ", decrypted.equals(message));

    }
}
