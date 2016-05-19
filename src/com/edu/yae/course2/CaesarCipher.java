package com.edu.yae.course2;

/**
 * JavaProgrammingCourse2
 * Created by yvalain on 16/05/2016.
 */
public class CaesarCipher {

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = getShiftedAlphabet(key);
        boolean isLowercase = false;

        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)) {
                currChar = Character.toUpperCase(currChar);
                isLowercase = true;
            }
            // regarder si elle est dans le shifted
            int idx = alphabet.indexOf(currChar);
            // si elle y est la positionner
            if (idx != -1) {
                char newChar = alphabet.charAt(i);
                if (isLowercase) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }


//    public String encryptTwoKeys(String input, int key1, int key2) {
//        StringBuilder encrypted = new StringBuilder(input);
//
//        for (int i = 0; i < encrypted.length(); i+=2) {
//            char currChar = encrypted.charAt(i);
//            char nextChar = encrypted.charAt(i++);
//
//            String shiftedAlphabet = getShiftedAlphabet(key1);
//
//        }
//        return encrypted.toString();
//    }

    private String getShiftedAlphabet(int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return alphabet.substring(key) + alphabet.substring(0, key);
    }

}
