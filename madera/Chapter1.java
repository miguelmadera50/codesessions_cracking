package com.company;

import java.util.Arrays;

class Chapter1 {
    Chapter1() {

        // Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
        // additional data structures?

        // Positive, w/ data structures
        assert problem1a("");
        assert problem1a("a");
        assert problem1a("abc");
        assert problem1a("qwertyuiopasdfghjklzxcvbnm");

        // Negative, w/ data structures;
        assert !problem1a("aa");
        assert !problem1a("qwertyuiopasdfghjklzxcvbnq");
        assert !problem1a("qwertyuiopasdfghjklzxcvbnzuythe");
        assert !problem1a("qwertyhnbgfdsabzxc");

        // Positive, wo/ data structures;
        assert problem1b("");
        assert problem1b("a");
        assert problem1b("abc");
        assert problem1b("qwertyuiopasdfghjklzxcvbnm");

        // Negative, wo/ data structures;
        assert !problem1b("aa");
        assert !problem1b("qwertyuiopasdfghjklzxcvbnq");
        assert !problem1b("qwertyuiopasdfghjklzxcvbnzuythe");
        assert !problem1b("qwertyhnbgfdsabzxc");
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

    // O(n) approach, similar to last problem, using bit array to account for duplicate characters
    private boolean problem2(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] intarr = new int[26];
        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();

        for (int i = 0; i < a.length(); i++) {
            intarr[a_arr[i] - 'a']++;
            intarr[b_arr[i] - 'a']--;
        }

        for (int i: intarr) {
            if (i != 0) return false;
        }
        return true;
    }
}