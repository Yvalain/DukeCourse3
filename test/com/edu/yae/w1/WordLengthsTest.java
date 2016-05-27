package com.edu.yae.w1;

import com.edu.duke.FileResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 27/05/2016.
 */
public class WordLengthsTest {

    private WordLengths wordLengths;

    @Before
    public void setUp() throws Exception {
        wordLengths = new WordLengths();
    }

    @Test
    public void testCountWordLengths() throws Exception {
        FileResource fileRes = new FileResource("./test/small.txt");
        int [] count = new int [13];

        wordLengths.countWordLengths(fileRes, count);
        int [] frequencies = wordLengths.getWordsFrequency();
        for (int freq : frequencies) {
            System.out.println(freq);
        }

        Assert.assertNotNull("The resource is not empty", frequencies);
        Assert.assertTrue("There should be 6 words of 3 letters", 6 == frequencies[3]);
    }

    @Test
    public void testCountWordLengthsSmallHamlet() throws Exception {
        FileResource fileRes = new FileResource("./test/smallHamlet.txt");
        int [] count = new int [31];

        wordLengths.countWordLengths(fileRes, count);
        int [] frequencies = wordLengths.getWordsFrequency();
        for (int freq : frequencies) {
            System.out.println(freq);
        }

        Assert.assertNotNull("The resource is not empty", frequencies);
        Assert.assertTrue("index of Max should be 3", 3 == wordLengths.indexOfMax(frequencies));
    }
}