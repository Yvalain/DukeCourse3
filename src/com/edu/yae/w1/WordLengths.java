package com.edu.yae.w1;

import com.edu.duke.FileResource;

import java.util.ArrayList;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 26/05/2016.
 */
public class WordLengths {

    private int[] frequencies;

    public void countWordLengths(FileResource resource, int [] counts) {
        ArrayList<String> words = new ArrayList<>();
        for (String string : resource.words()) {
            words.add(string);
        }
        frequencies = findWordsFrequency(words, counts);
    }

    public int[] getWordsFrequency() {
        return frequencies;
    }

    public int indexOfMax(int [] values) {
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > index ) {
                index = i;
            }
        }
        return index;
    }

    private int[] findWordsFrequency(ArrayList<String> words, int[] counts) {
        for (int i = 0; i < words.size(); i++) {
            if (i < counts.length ) {
                int numberOfLetters = getWordLength(words.get(i));
                counts[numberOfLetters] += 1;
            } else {
                counts[counts.length - 1] ++;
            }
        }
        return counts;
    }

    private int getWordLength(String word) {
        StringBuilder builder = new StringBuilder(word);
        for (int i = 0; i < builder.length(); i++) {
            if (!Character.isLetter(builder.charAt(i)))
                builder.deleteCharAt(i);
        }
        return builder.length();
    }
}
