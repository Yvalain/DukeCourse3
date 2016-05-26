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

    private FileResource fileRes;
    private WordLengths wordLengths;

    @Before
    public void setUp() throws Exception {
        fileRes = new FileResource("./test/small.txt");
        wordLengths = new WordLengths();
    }

    @Test
    public void testCountWordLengths() throws Exception {
        wordLengths.countWordLengths(fileRes);
        int [] counts = wordLengths.getWordsFrequency();
        for (int count : counts) {
            System.out.println(count);
        }

        Assert.assertNotNull("The resource is not empty", counts);
        Assert.assertTrue("There should be 6 words of 3 letters", 6 == counts[3]);
    }
}