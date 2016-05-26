package com.edu.yae.w1;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
class CaesarCipher {

    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private boolean isLowercase = false;
    private StringBuilder encrypted;
    private String shiftedAlphabet;

    public String encrypt(String input, int key) {
        encrypted = new StringBuilder(input);
        shiftedAlphabet = getShiftedAlphabet(key);

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

    public String encryptTwoKeys(String input, int firstKey, int secondKey) {
        encrypted = new StringBuilder(input);

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);

            shiftedAlphabet = getAlphabet(firstKey, secondKey, i);

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

    private String getAlphabet(int firstKey, int secondKey, int i) {
        if (i % 2 == 0) {
            return getShiftedAlphabet(firstKey);
        } else {
            return getShiftedAlphabet(secondKey);
        }
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
