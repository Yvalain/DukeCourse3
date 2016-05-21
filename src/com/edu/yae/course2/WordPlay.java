package com.edu.yae.course2;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 21/05/2016.
 */
class WordPlay {

    public boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public String replaceVowels(String str, char chr) {
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < strBuilder.length(); i++) {
            char charac = strBuilder.charAt(i);
            if (isVowel(charac)) {
                strBuilder.setCharAt(i, chr);
            }
        }
        return strBuilder.toString();
    }
}
