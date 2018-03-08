/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

/**
 *
 * @author RAMON
 */
public class IsUnique {

    public static void main(String[] args) {
        String word = "";
        boolean isUnique = IsUnique(word);
        System.out.println(word + " is unique?: " + isUnique);
    }

    public static boolean IsUnique(String word) {
        boolean isUnique = true;
        for (int i = 0; i < word.length(); i++) {
            String substring = word.substring(i + 1, word.length());
            isUnique = !substring.contains(String.valueOf(word.charAt(i)));
            if (!isUnique) {
                break;
            }
        }
        return isUnique;
    }
}
