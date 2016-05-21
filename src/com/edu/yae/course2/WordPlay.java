package com.edu.yae.course2;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 21/05/2016.
 */
class WordPlay {

    public boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public String replaceVowels(String phrase, char chr) {
        StringBuilder strBuilder = new StringBuilder(phrase);
        for (int i = 0; i < strBuilder.length(); i++) {
            char charac = strBuilder.charAt(i);
            if (isVowel(charac)) {
                strBuilder.setCharAt(i, chr);
            }
        }
        return strBuilder.toString();
    }

    public String emphasize(String phrase, char chr) {
        StringBuilder strBuilder = new StringBuilder(phrase);
        char toUse;
        for (int i = 0; i < strBuilder.length(); i++) {
            char charac = strBuilder.charAt(i);
            if (charac == chr) {
                toUse = getTheReplacementCharacter(i);
                strBuilder.setCharAt(i, toUse);
            }
        }
        return strBuilder.toString();
    }

    private char getTheReplacementCharacter(int i) {
        return  (i % 2 == 0) ? '*' : '+';
    }
}
