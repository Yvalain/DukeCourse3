package com.edu.yae.w1;

import com.edu.duke.FileResource;

import java.util.HashSet;
import java.util.Set;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 26/05/2016.
 */
public class WordLengths {

    private int[] counts;

    public void countWordLengths(FileResource resource) {
        Set<String> words = new HashSet<>();
        for (String string : resource.words()) {
            words.add(string);
        }

        findWordsFrequency(resource, words);

    }

    public int[] getWordsFrequency() {
        return counts;
    }

    private void findWordsFrequency(FileResource resource, Set<String> words) {
        counts = new int[words.size()];

        for (String word : resource.words()) {
            int numberOfLetters = word.length();
            counts[numberOfLetters] += 1;
        }
    }
}
