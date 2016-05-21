package com.edu.yae.course2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 21/05/2016.
 */
public class WordPlayTest {
    private final WordPlay newWordPlay = new WordPlay();
    private char character;

    @Test
    public void isVowel() {
        character = 'a';
        Assert.assertTrue("Letter is vowel", newWordPlay.isVowel(character));
    }

    @Test
    public void isNotVowel() {
        character = 'x';
        Assert.assertFalse("Letter is not a vowel", newWordPlay.isVowel(character));
    }

    @Test
    public void replaceVowels() {
        String str = "Hello World";
        char chr = '*';

        Assert.assertTrue("Vowels are well replaced ", "H*ll* W*rld".equals(newWordPlay.replaceVowels(str, chr)));
    }

    @Test
    public void emphasize() {
        String str = "Mary Bella Abracadabra";
        char chr = 'a';
        System.out.println(newWordPlay.emphasize(str, chr));

        Assert.assertTrue("Vowels are well replaced ", "M+ry Bell+ +br*c*d*br+".equals(newWordPlay.emphasize(str, chr)));
    }
}
