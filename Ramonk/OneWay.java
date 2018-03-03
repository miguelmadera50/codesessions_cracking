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
public class OneWay {
    public static void main(String[] args) {
        String word1 = "a";
        String word2 = "aaa";
        boolean result = false;
        int diff = word1.length() - word2.length();
        
        if (diff > 1 || diff < -1){
            result = false;
        } else{
            if (word1.length() == 1 || word2.length() == 1){
                result = true;
            } else if ((word1.length() == 2 && word2.length() == 1) || (word1.length() == 1 && word2.length() == 2)){
                result = true;
            }else if (diff == 0){
                result = replace(word1, word2);
            }
            else{
                result = add(word1, word2); 
            }
        } 
        
        System.out.println("Are they one edit away?: " + result);
    }
    
    private static boolean replace(String word1, String word2){
        int count = 0;
        for (int i= 0; i<word1.length();i++){
            String var1 = String.valueOf(word1.charAt(i));
            String var2 = String.valueOf(word2.charAt(i));
            if (!var1.equals(var2)){
                count++;
            }
        }
        return count<=1;
    }
    
    private static boolean add (String word1, String word2){
        String first = word1;
        String second = word2;
        int count = 0;
        int j = 0;
        if (word1.length() < word2.length()){
            first = word2;
            second = word1;
        }
        for (int i= 0; i<first.length();i++){
            String var1 = String.valueOf(first.charAt(i));
            String var2 = String.valueOf(second.charAt(j));
            if (!var1.equals(var2)){
                count++;
                j--;
                if (count > 1){
                    return false;
                }
            }
            j++;
        }
        return true;
    }
}
