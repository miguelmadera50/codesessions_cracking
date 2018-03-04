/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.durango.codesessions;

/**
 *
 * @author QG
 */
public class Compression {

    public static void main(String[] args) {
        String word = "aaabbbccc";
        String compressed = Compression(word);

        System.out.println("The smaller word is: " + compressed);
    }

    public static String Compression(String word) {
        int count = 1;
        String compressed = "";
        int length = word.length();
        for (int i = 0; i < length; i++) {
            String var1 = String.valueOf(word.charAt(i));
            if (i + 1 < length) {                
                String var2 = String.valueOf(word.charAt(i + 1));
                if (var1.equals(var2)) {
                    count++;
                } else {
                    compressed += var1 + count;
                    count = 1;
                }
            }
            else{                
                compressed += var1 + count;                    
            }
        }
        return compressed.length() >= length ? word : compressed;
    }

}
