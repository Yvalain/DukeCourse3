package com.edu.yae.course2;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipher {

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            String alphabet = getAlphabetInGoodCase(currChar);
            String shiftedAlphabet = getShiftedAlphabet(alphabet, key);

            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    private String getShiftedAlphabet(String alphabet, int key) {
        return alphabet.substring(key) + alphabet.substring(0, key);
    }

//    private String replaceInText(String alphabet, String text, char currChar) {
//        int idx = alphabet.indexOf(currChar);
//        if (idx != -1) {
//            char newChar = shiftedAlphabet.charAt(idx);
//            encrypted.setCharAt(i, newChar);
//        return text;
//    }

    private String getAlphabetInGoodCase(char currChar) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (Character.isLowerCase(currChar)) {
            alphabet = alphabet.toLowerCase();
        }
        return alphabet;
    }
}
