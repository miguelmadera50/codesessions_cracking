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
        result = OneWay(word1, word2);
        System.out.println("Are they one edit away?: " + result);
    }
    
    public static boolean OneWay(String word1, String word2){
        boolean result = false; 
        int length1 = word1.length();
        int length2 = word2.length();
        int diff = length1 - length2;
        
        if (diff > 1 || diff < -1){
            result = false;
        } else{
            if (length1 == 1 || length2 == 1){
                result = true;
            } else if ((length1 == 2 && length2 == 1) || (length1 == 1 && length2 == 2)){
                result = true;
            }else if (diff == 0){
                result = replace(word1, word2);
            }
            else{
                result = add(word1, word2); 
            }
        }
        return result;
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
