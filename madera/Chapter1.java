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

        // String Compression: Implement a method to perform basic string compression using the counts of repeated
        // characters. For example, the string "aabcccccaaa" would become "a2b1c5a3". If the compressed string would not
        // become smaller than the original string, your method should return the original string. You can assume the
        // string has only uppercase and lowercase letters.
        assert problem6("").equals("");
        assert problem6("a").equals("a");
        assert problem6("aa").equals("aa");
        assert problem6("aaa").equals("a3");
        assert problem6("aaabbbccc").equals("a3b3c3");
        assert problem6("abcdefgh").equals("abcdefgh");
        assert problem6("aabgggarrraatttt").equals("a2b1g3a1r3a2t4");
        assert problem6("aabgggarrraatt").equals("aabgggarrraatt");

        // Rotate Matrix: Given an image represented by an MxN matrix, where each pixel in the image is 4 bytes, write a
        // method to rotate the image by 90 degrees. Can you do this in-place?
        int[][] test_arr_a = new int[][] {
                {1, 1, 2, 3},
                {2, 9, 0, 1},
                {6, 6, 6, 2},
                {0, 6, 5, 1}
        };
        int[][] test_arr_b = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] test_arr_c = new int[][] {
                {1, 2},
                {3, 4}
        };

        problem7(test_arr_a);
        problem7(test_arr_b);
        problem7(test_arr_c);
        assert Arrays.deepEquals(test_arr_a, new int[][]{
                {0, 6, 2, 1},
                {6, 6, 9, 1},
                {5, 6, 0, 2},
                {1, 2, 1, 3}
        });
        assert Arrays.deepEquals(test_arr_b, new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        });
        assert Arrays.deepEquals(test_arr_c, new int[][]{
                {3, 1},
                {4, 2}
        });

        // Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are
        // set to 0.
        int[][] test_arr_d = new int[][] {
                {1, 1, 2, 3},
                {2, 9, 0, 1},
                {6, 6, 6, 2},
                {0, 6, 5, 1},
                {7, 3, 1, 1}
        };
        int[][] test_arr_e = new int[][] {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        int[][] test_arr_f = new int[][] {
                {1, 0},
                {0, 4},
        };
        problem8(test_arr_d);
        problem8(test_arr_e);
        problem8(test_arr_f);
        assert Arrays.deepEquals(test_arr_d, new int[][]{
                {0, 1, 0, 3},
                {0, 0, 0, 0},
                {0, 6, 0, 2},
                {0, 0, 0, 0},
                {0, 3, 0, 1}
        });
        assert Arrays.deepEquals(test_arr_e, new int[][]{
                {1, 0, 3},
                {0, 0, 0},
                {7, 0, 9}
        });
        assert Arrays.deepEquals(test_arr_f, new int[][]{
                {0, 0},
                {0, 0}
        });

        // String Rotation: Assume you have a method isSubstring which checks if one work is a substring of another.
        // Given two strings, s1 and s2, write code to ch3eck if s2 is a rotation of s1 by using only one call to
        // isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
        // Positive
        assert problem9("", "");
        assert problem9("aba", "baa");
        assert problem9("waterbottle", "erbottlewat");
        assert problem9("rotation", "ationrot");

        // Negative
        assert !problem9("", "a");
        assert !problem9("aba", "bba");
        assert !problem9("waterbottle", "erbotltewat");
        assert !problem9("rotation", "ationrotat");

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

    // O(n) approach [O(2n)], simply iterating and getting the derived string while keeping track of its length
    private String problem6(String string) {
        int string_length = string.length();
        int j = 0;
        int i = 0;
        int character_count = 0;
        char c = ' ';

        char[] arr = string.toCharArray();
        char[] derived = new char[string_length * 2];  // Max size that this can reach (all uniques)

        // Simple Base Case
        if (string_length < 2) return string;

        while (i < string_length) {
            if (character_count == 0) {
                derived[j++] = c = arr[i];
                character_count++;
                i++;
            }
            else if (arr[i] == c) {
                character_count++;
                i++;
            } else {
                for(char ch: String.valueOf(character_count).toCharArray()) derived[j++] = ch;
                character_count = 0;
            }
        }

        // One last iteration for last number
        for(char ch: String.valueOf(character_count).toCharArray()) derived[j++] = ch;

        if (j >= string_length) return string;
        else return String.valueOf(derived).trim();
    }

    // O(n) (where n is the amount of elements (NxN) ) in place, uses a single holder variable
    private void problem7(int[][] arr) {
        int arr_length = arr.length;
        if (arr_length < 2) return;

        int a, b, c, d, i_lim, j_lim;
        double half = ( (double) arr_length) / 2;

        if (arr_length % 2 == 1){
            i_lim = (int) Math.ceil(half);
            j_lim = (int) Math.floor(half);
        } else {
            i_lim = j_lim = (int) half;
        }

        for (int i = 0; i < i_lim; i++){
            for (int j = 0; j < j_lim; j++){
                a = arr[i][j];
                b = arr[j][arr_length - i - 1];
                c = arr[arr_length - i - 1][arr_length - j - 1];
                d = arr[arr_length - j - 1][i];

                arr[i][j] = d;
                arr[j][arr_length - i - 1] = a;
                arr[arr_length - i - 1][arr_length - j - 1] = b;
                arr[arr_length - j - 1][i] = c;
            }
        }
    }

    // O(n) (2n) in place solution, one to read and one to write.
    private void problem8(int[][] arr) {
        int row_cnt = arr.length;
        int row_len = arr[0].length;
        boolean[] rows = new boolean[row_cnt];
        boolean[] cols = new boolean[row_len];

        for (int i = 0; i < row_cnt; i++) {
            for (int j = 0; j < row_len; j++) {
                if (arr[i][j] == 0) rows[i] = cols[j] = true;
            }
        }

        for (int i = 0; i < row_cnt; i++) {
            for (int j = 0; j < row_len; j++) {
                if (rows[i] || cols[j]) arr[i][j] = 0;
            }
        }
    }

    // O(n) solution involving 1 append and a search
    private boolean problem9(String base, String string) {
        if (base.length() != string.length()) return false;
        String appended = string + string;
        return appended.contains(base);
    }
}
