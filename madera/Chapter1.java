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

        // Check Permutation: Given two strings, write a method to decide of one is a permutation of the other.
        // Positive - assuming only 26 chars
        assert problem2("", "");
        assert problem2("a", "a");
        assert problem2("zzzzzzz", "zzzzzzz");
        assert problem2("abcd", "dcba");
        assert problem2("qwertty", "tqweryt");

        // Negative - assuming only 26 chars
        assert !problem2("a", "b");
        assert !problem2("a", "aa");
        assert !problem2("aaaaa", "aa");
        assert !problem2("qwerty", "qwerti");
        assert !problem2("miridso", "miridsd");

        // URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has
        // sufficient space at the end to hold the additional characters, and that you are given the 'true' length of
        // the string.
        assert problem3("a b**").equals("a%20b");
        assert problem3("a b ****").equals("a%20b%20");
        assert problem3("a    b********").equals("a%20%20%20%20b");
        assert problem3("   ******").equals("%20%20%20");
        assert problem3("www google a com search **********").equals("www%20google%20a%20com%20search%20");

        // Palindrome Permutation: Given a string, write a function to check if it a permutation of a palindrome. A
        // palindrome is a rearrangement of letters. The palindrome  does not need to be limited to just dictionary
        // words.
        // Positive
        assert problem4("");
        assert problem4("a");
        assert problem4("aaaaaaaaaaaa");
        assert problem4("aab");
        assert problem4("abbab");
        assert problem4("qwqwerre");
        assert problem4("qrytweqwertyaaa");

        // Negative
        assert !problem4("ab");
        assert !problem4("qwer");
        assert !problem4("asjdoiasfyuenasdflkhehee");
        assert !problem4("alpqalpqlapqcalpqbhbht");

        // One Away: There are three types of edits that can be performed on strings: insert a character, remove a
        // character, or replace a character. Given two strings, write a function to check if they are one edit (or
        // zero edits) away.
        // Positive
        assert problem5("", "");
        assert problem5("aa", "aa");
        assert problem5("", "a");
        assert problem5("a", "");
        assert problem5("a", "b");
        assert problem5("q", "qq");
        assert problem5("qq", "q");

        // Negative
        assert !problem5("ba", "");
        assert !problem5("word", "dwor");
        assert !problem5("ab", "ba");
        assert !problem5("a", "aaa");
        assert !problem5("qwer", "qrew");

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

    // O(n) in-place approach, simply traversing backwards and inserting with two references
    private String problem3(String string) {
        char[] arr = string.toCharArray();
        int last_index = string.length() - 1;

        for (int i = string.length() - 1; i >= 0 ; i--) {
            if (arr[i] == '*') continue;

            if (arr[i] == ' ') {
                arr[last_index] = '0';
                arr[last_index - 1] = '2';
                arr[last_index - 2] = '%';
                last_index -= 3;
            } else {
                arr[last_index] = arr[i];
                last_index--;
            }
        }
        return String.valueOf(arr);
    }

    // O(n) approach, a boolean array is flipped whenever a letter is found. Palindrome arrays at most have one 'on'.
    private boolean problem4(String string) {
        boolean[] boolarr = new boolean[26];
        char[] arr = string.toCharArray();
        int sum = 0;

        for (char c: arr) boolarr[c - 'a'] = !boolarr[c - 'a'];
        for (boolean b: boolarr) sum += b ? 1: 0;

        return sum < 2;
    }

    // 0(n) max approach, for all cases, insertions are same as removals in this case
    private boolean problem5(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();
        int len_dif = a_len - b_len;
        int differences = 0;

        // Base cases
        if (a.equals(b)) return true;
        if (len_dif > 1 || len_dif < -1) return false;

        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();

        // Replacement case
        if (a_len == b_len) {
            for (int i = 0; i < a_len; i++) {
                if (a_arr[i] != b_arr[i]) differences++;
            }
            return differences < 2;
        }

        // Only references, does not copy
        char[] max_arr = (a_len > b_len) ? a_arr: b_arr;
        char[] min_arr = (a_len < b_len) ? a_arr: b_arr;

        // Insert (or remove) case
        for (int i = 0; i < min_arr.length; i++) {
            if (max_arr[i + differences] != min_arr[i]) {
                if (differences > 0) return false;
                differences++;
            }
        }
        return true;
    }
}