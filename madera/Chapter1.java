package com.company;

import java.util.Arrays;

class Chapter1 {
    Chapter1() {

        // Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
        // additional data structures?
        String unique = "qwerty";
        String not_unique = "qwyerty";
        System.out.println("Problem 1a: " + problem1a(unique));
        System.out.println("Problem 1a: " + !problem1a(not_unique));
        System.out.println("Problem 1b: " + problem1b(unique));
        System.out.println("Problem 1b: " + !problem1b(not_unique));
    }

    // O(n^2) approach, simple iteration
    private boolean problem1a(String string) {
        int len = string.length();
        char[] arr = string.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) return false;
            }
        }
        return true;
    }

    // O(n) approach, assuming only lowercase ascii letters, can also use a 32bit int as a DS, shifting bits
    private boolean problem1b(String string) {
        boolean[] boolarr = new boolean[26];
        char[] arr = string.toCharArray();

        for (char c: arr) {
            if (boolarr[c - 'a']) return false;
            boolarr[c - 'a'] = true;
        }
        return true;
    }
}