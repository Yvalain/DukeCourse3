package com.edu.yae.course2;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipher {

    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    boolean isLowercase = false;

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String shiftedAlphabet = getShiftedAlphabet(key);

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            if (Character.isLowerCase(currChar)) {
                currChar = Character.toUpperCase(currChar);
                isLowercase = true;
            }

            int idx = shiftedAlphabet.indexOf(currChar);

            if (idx != -1) {
                char newChar = alphabet.charAt(idx);
                newChar = getCharInGoodCase(newChar);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    private char getCharInGoodCase(char newChar) {
        if (isLowercase) {
            newChar = Character.toLowerCase(newChar);
        }
        isLowercase = false;
        return newChar;
    }

    private String getShiftedAlphabet(int key) {
        return alphabet.substring(alphabet.length() - key) + alphabet.substring(0, alphabet.length() - key);
    }

}
